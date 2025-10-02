import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor
{
    //setting up all instance variables, animations, jumping, direction, and action
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
    private Action currentAction; //both action and direction are enums
    private Direction direction;

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
        direction = Direction.right;
        isJumping = false;
        jumpTimer = new Timer(5000);
    }
    
    //the following setter methods are to set the corresponding animation to the action the cat is in
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
        //sets up new action 
        Action newAction = null;
        if (currentAction == null) {
            newAction = Action.idle;
        }
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        //the following if/else statements are to set keyboard functions (up,down,left,right)
        //sets the new location, checks if the position is block, and changes animation accordingly
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) {
            setLocation(x+5, y);
            newAction = Action.walkRight;
            direction = Direction.right;
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
            newAction = Action.walkLeft;
            direction = Direction.left;
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
                newAction = Action.climb;
            }

            if (y < 0) {
                y = 0;
                setLocation(x, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            if (!isFalling()){
                setLocation(x, y+5);
            }
            if(isBlocked()){
                setLocation (x , y - 3);
            }
            if (isLadder()) {
                newAction = Action.climb;
                
            }
            if (y+h > 600) {
                y = 600 - h;
                setLocation(x, y);
            }
        }

        else if ((y+1+h < 600) && Mayflower.isKeyDown(Keyboard.KEY_SPACE))    {
            isJumping = false; //the down key has to account for falling and jumping
            if (jumpTimer.isDone() && !isFalling() && !isJumping()){
                setLocation (x , y - 150);
                isJumping = true;
            }
            if(isBlocked()){
                setLocation (x , y - 20);
                isJumping = false;
            }
            if (direction != null && direction == Direction.left && !isFalling()){
                newAction = Action.jumpLeft;
            }
            else if (direction != null && direction == Direction.right && !isFalling()){
                newAction = Action.jumpRight;   
            }
        } 

        else if(isFalling()) {
            newAction = Action.falling;
        }

        else {
            newAction = Action.idle;
            if(direction != null && direction.equals("left")) {
                newAction = Action.idleLeft;
            }
        }
        //the following if/else statements set the animation to the new action 

        if (newAction != null && !newAction.equals(currentAction)) {
            if(newAction == Action.walkRight) {
                setAnimation(walkRight);
            }
            else if(newAction == Action.idle) {
                setAnimation(idle);
            }
            else if(newAction == Action.walkLeft) {
                setAnimation(walkLeft);
            }
            else if(newAction == Action.idleLeft) {
                setAnimation(idleLeft);
            }
            else if(newAction == Action.falling) {
                if(direction == Direction.left){
                    setAnimation(fallLeft);
                }
                else if(direction == Direction.right) {
                    setAnimation(fallRight);
                }
            }
            else if (newAction == Action.jumpRight){
                setAnimation(jumpRight);   
            }
            else if (newAction == Action.jumpLeft){
                setAnimation(jumpLeft);   
            }
            else if(newAction == Action.climb) {
                setAnimation(climb);
            }
           currentAction = newAction;
        }

            
    }
}