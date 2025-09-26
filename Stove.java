
import mayflower.*;
public class Stove extends Actor
{
    // instance variables - replace the example below with your own
    private Timer textTimer;

    
    public Stove()
    {
        textTimer = new Timer(100);
    }

    
    public void act()
    {
        // put your code here
        setImage("img/Tiles/stove.png");
        
        if (isTouching(Cat.class)) {
            World w = getWorld();
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            int x = c.getX();
            int y = c.getY();
            c.decreaseLives(1);
            c.setLocation(x-100, y);
            c.updateText();
        }
        //this.scale(100, 100);
        
    }
}
