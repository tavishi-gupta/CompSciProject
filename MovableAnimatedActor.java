import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private Enum Direction;
    private String currentAction;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation fallingLeft;
    private Animation fallingRight;
    private Animation jumpRight;
    private Animation jumpLeft;
    private boolean isJumping;
    private Timer jumpTimer;

    public MovableAnimatedActor(){
        walkRight = null;
        idle = null; 
        currentAction = null;
        walkLeft = null;
        idleLeft = null;
        fallingLeft = null;
        fallingRight = null;
        jumpRight = null;
        jumpLeft = null;
        Direction = null;
        isJumping = false;
        jumpTimer = new Timer(5000);
    }

    public void act(){
        super.act();
        String newAction = null;

        if (currentAction == null){
            newAction = "idle";
        }

        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if (((x+1+w)<800) && (Mayflower.isKeyDown(Keyboard.KEY_RIGHT))) {
            Direction = Direction.right;
            setLocation(x+1, y);
            if(isBlocked()){
                setLocation (x - 1, y);

            }
            newAction = "walkRight";
            // if (isFalling()){
            // newAction = "fallingRight";   
            // }

        }
        else if ((x-1 > 0) && Mayflower.isKeyDown(Keyboard.KEY_LEFT)) {
            Direction = Direction.left;
            setLocation(x-1, y);
            if(isBlocked()){
                setLocation (x + 1, y);
            }
            newAction = "walkLeft";
            // if (isFalling()){
            // newAction = "fallingLeft";   
            // }

        }
        else if ((y-10 > 0) && Mayflower.isKeyDown(Keyboard.KEY_UP))
        {


        }
        else if ((y+1+h < 600) && Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            //setLocation(x, y+1);   
            if(isBlocked()){
                setLocation (x, y - 1);
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
            if (direction != null && direction.equals(Direction.left) && !isFalling()){
                newAction = "jumpLeft";
            }
            else if (direction != null && direction.equals(Direction.right) && !isFalling()){
                newAction = "jumpRight";   
            }
        } 
        else {
            newAction = "idle";
            if (direction != null && direction == Direction.left){
                newAction = "idleLeft";
            }
            if (direction != null && direction.equals(Direction.right) && isFalling()){
                newAction = "fallingRight";   
            }
            if (direction != null && direction.equals(Direction.left) && isFalling()){
                newAction = "fallingLeft";   
            }
        }

        if (newAction != null && !newAction.equals(currentAction) ){
            if (newAction.equals(Action.walkRight)){
                setAnimation(walkRight);
            }
            if (newAction.equals(  Action.walkLeft)){
                setAnimation(walkLeft);
            }
            if (newAction.equals("idle")){
                setAnimation(idle);   
            }
            if (newAction.equals("idleLeft")){
                setAnimation(idleLeft);   
            }
            if (newAction.equals("fallingLeft")){
                setAnimation(fallingLeft);   
            }
            if (newAction.equals("fallingRight")){
                setAnimation(fallingRight);   
            }
            if (newAction.equals("jumpRight")){
                setAnimation(jumpRight);   
            }
            if (newAction.equals("jumpLeft")){
                setAnimation(jumpLeft);   
            }
            currentAction = newAction;
        }

    }

    public void setWalkRightAnimation(Animation ani){
        walkRight = ani;
    }

    public void setIdleAnimation(Animation ani){
        idle = ani;
    }

    public void setIdleLeftAnimation(Animation ani){
        idleLeft = ani;
    }

    public void setWalkLeftAnimation(Animation ani){
        walkLeft = ani;
    }

    public void setFallingLeftAnimation(Animation ani){
        fallingLeft = ani;
    }

    public void setFallingRightAnimation(Animation ani){
        fallingRight = ani;
    }

    public void setJumpRightAnimation(Animation ani){
        jumpRight = ani;
    }

    public void setJumpLeftAnimation(Animation ani){
        jumpLeft = ani;
    }
}
