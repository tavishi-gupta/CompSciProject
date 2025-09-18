import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private boolean isJumping;
    private Timer jumpTimer;
    private Animation climb;
    private String currentAction;
    private String direction;
    

    public MovableAnimatedActor()
    {
        // initialise instance variables
        walkRight = null;
        walkLeft = null;
        idle = null;
        idleLeft = null;
        fallRight = null;
        fallLeft = null;
        currentAction = null;
        jumpLeft = null;
        jumpRight = null;
        climb = null;
        direction = "right";
        isJumping = false;
        jumpTimer = new Timer(5000);
    }

    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }

    public void setWalkRightAnimation(Animation ani) {
        walkRight = ani;
    }
    
    public void setClimbAnimation(Animation ani) {
        climb = ani;
    }

    public void setIdleAnimation(Animation ani) {
        idle = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani) {
        walkLeft = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani) {
        idleLeft = ani;
    }
    
    public void setFallLeftAnimation(Animation ani) {
        fallLeft = ani;
    }
    
    public void setFallRightAnimation(Animation ani) {
        fallRight = ani;
    }
    
    public void setJumpRightAnimation(Animation ani){
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani){
        jumpLeft = ani;
    }

    public void act()
    {
        super.act();
        String newAction = null;
        if (currentAction == null) {
            newAction = "idle";
        }
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) {
            setLocation(x+5, y);
            newAction = "walkRight";
            direction = "right";
            if (isBlocked()) {
                setLocation(x-5, y);
            }
            if (x+w > 800) {
                x = 800 - w;
                setLocation(x, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)) {
            setLocation(x-5, y);
            newAction = "walkLeft";
            direction = "left";
            if (isBlocked()) {
                setLocation(x+5, y);
            }
            if (x < 0) {
                x = 0;
                setLocation(x, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_UP)) {
            //setLocation (x , y - 20);
            if(isBlocked()){
                setLocation (x , y + 3);
            }
            if (isLadder()) {
                setLocation (x , y - 20);
                newAction = "climb";
            }
            
            if (y < 0) {
                y = 0;
                setLocation(x, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            setLocation(x, y+5);
            if (isBlocked()) {
                setLocation(x, y-1);
            }
            if (isLadder()) {
                newAction = "climb";
            }
            if (y+h > 600) {
                y = 600 - h;
                setLocation(x, y);
            }
        }
        
        else if ((y+1+h < 600) && Mayflower.isKeyDown(Keyboard.KEY_SPACE))    {
            isJumping = false;
            if (jumpTimer.isDone() && !isFalling() && !isJumping()){
                setLocation (x , y - 150);
                isJumping = true;
            }
            if(isBlocked()){
                setLocation (x , y - 20);
                isJumping = false;
            }
            if (direction != null && direction == "left" && !isFalling()){
                newAction = "jumpLeft";
            }
            else if (direction != null && direction == "right" && !isFalling()){
                newAction = "jumpRight";   
            }
        } 
        
        else if(isFalling()) {
            newAction = "falling";
        }
      
        else {
           newAction = "idle";
           if(direction != null && direction.equals("left")) {
               newAction = "idleLeft";
           }
        }

        if (newAction != null && !newAction.equals(currentAction)) {
           if(newAction.equals("walkRight")) {
                setAnimation(walkRight);
           }
           else if(newAction.equals("idle")) {
                setAnimation(idle);
           }
           else if(newAction.equals("walkLeft")) {
               setAnimation(walkLeft);
           }
           else if(newAction.equals("idleLeft")) {
               setAnimation(idleLeft);
           }
           else if(newAction.equals("falling")) {
               if(direction.equals("left")){
                   setAnimation(fallLeft);
               }
               else if(direction.equals("right")) {
                   setAnimation(fallRight);
               }
           }
           else if (newAction.equals("jumpRight")){
                setAnimation(jumpRight);   
            }
           else if (newAction.equals("jumpLeft")){
                setAnimation(jumpLeft);   
           }
           else if(newAction.equals("climb")) {
               setAnimation(climb);
           }
           currentAction = newAction;
        }

                
            
        
    }
}
