import mayflower.*;
public class Remy extends AnimatedActor
{
    private Animation idle;
    private Timer moveTimer;
    private Direction direction;
    private int lowYBound;
    private int lowXBound;
    private int highYBound;
    private int highXBound;
    public Remy(){
        //setImage("img/Remy.png");
        String [] idleName = new String[10];
        for (int i = 0; i < idleName.length; i++) {
            idleName[i] = "img/Remy (" + (i+1) + ").png";
        }
        idle = new Animation(50, idleName);
        setAnimation(idle);
        idle.scale(100, 87);
        moveTimer = new Timer(1000);
        //idle.setBounds(18, 5, 54, 80);
        direction = Direction.right;
    }
    
    public void setRemyBounds (int lowx, int lowy, int highx, int highy) {
        lowXBound = lowx;
        lowYBound = lowy;
        highXBound = highx;
        highYBound = highy;
        
    }
    public void act(){
        super.act();
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        if (direction == Direction.right) {
            setLocation(x+20, y);
        }
        if (direction == Direction.left) {
            setLocation(x-20, y);
        }
        if (x+w > highXBound) {
            x = highXBound - w;
            setLocation(x, y);
            direction = Direction.left;
        }
        if (x < lowXBound) {
            x = lowXBound;
            setLocation(x, y);
            direction = Direction.right;
        }
        if (y < lowYBound) {
            y = lowYBound;
            setLocation(x, y);
        }
        if (y+h > highYBound) {
            y = highYBound - h;
            setLocation(x, y);
        }
        
    
    }
}
