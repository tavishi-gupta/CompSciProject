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
        
        lowXBound = 0;
        highXBound = 800;
        setFalls (false);
    }
    
    public void setRemyBounds (int lowx, int highx) {
        lowXBound = lowx;
        
        highXBound = highx;
        
        
    }
    public void act(){
        super.act();

     
        if (direction == Direction.right) {
            setLocation(getX()+5, getY());
            if (getX() + getWidth() >= highXBound){
                direction = Direction.left;
            }
        } else if (direction == Direction.left) {
            setLocation(getX()-5, getY());
            if (getX()<= lowXBound){
                direction = Direction.right;
            }
        }
        
        if (isTouching(Cat.class)) {
            World w = getWorld();
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            int x = c.getX();
            int y = c.getY();
            c.decreaseLives(1);
            c.setLocation(getX(), getY()+100);
            c.updateText();
        }
        
        // if (x+w > highXBound) {
            // x = highXBound - w;
            // setLocation(x, y);
            // direction = Direction.left;
        // }
        // if (x < lowXBound) {
            // x = lowXBound;
            // setLocation(x, y);
            // direction = Direction.right;
        // }
        // if (y < lowYBound) {
            // y = lowYBound;
            // setLocation(x, y);
        // }
        // if (y+h > highYBound) {
            // y = highYBound - h;
            // setLocation(x, y);
        // }
        
    
    }
}
