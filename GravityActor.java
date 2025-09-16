import mayflower.*;
public class GravityActor extends Actor
{
   
    public GravityActor()
    {
        
    }
    
    public boolean isBlocked() {
        if (isTouching(Block.class)) {
            return true;
        }
        return false;
    }
    
    public boolean isLadder() {
        if (isTouching(Ladder.class)) {
            return true;
        }
        return false;
    }
    
    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 5);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 5);
        return !ret;
    }
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        setLocation(x, y+1);
        if (isBlocked()) {
            setLocation(x, y-1);
        }
        if (y+h > 600) {
            y = 600 - h;
            setLocation(x, y);
        }
    }
}
