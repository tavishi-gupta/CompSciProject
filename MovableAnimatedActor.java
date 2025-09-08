import mayflower.*;
/**
 * Write a description of class MovableAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private String direction;
    private String currentAction;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation fallingLeft;
    private Animation fallingRight;

    public MovableAnimatedActor(){
        walkRight = null;
        idle = null; 
        currentAction = null;
        walkLeft = null;
        idleLeft = null;
        fallingLeft = null;
        fallingRight = null;
        direction = "right";
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
            direction = "right";
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
            direction = "left";
            setLocation(x-1, y);
            if(isBlocked()){
                setLocation (x + 1, y);
            }
            newAction = "walkLeft";
            // if (isFalling()){
                // newAction = "fallingLeft";   
            // }

        }
        else if ((y-1 > 0) && Mayflower.isKeyDown(Keyboard.KEY_UP)) {
            setLocation (x , y - 1);
            if(isBlocked()){
                setLocation (x , y + 1);
            }
        }
        else if ((y+1+h < 600) && Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            setLocation(x, y+1);   
            if(isBlocked()){
                setLocation (x, y - 1);
            }
        } 
        else {
            newAction = "idle";
            if (direction != null && direction == "left"){
                newAction = "idleLeft";
            }
            if (direction != null && direction == "right" && isFalling()){
             newAction = "fallingRight";   
            }
            if (direction != null && direction == "left" && isFalling()){
             newAction = "fallingLeft";   
            }
        }

        if (newAction != null && !newAction.equals(currentAction) ){
            if (newAction.equals("walkRight")){
                setAnimation(walkRight);
            }
            if (newAction.equals("walkLeft")){
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
}
