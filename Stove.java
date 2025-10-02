
import mayflower.*;
public class Stove extends Actor
{
    private Timer textTimer;

    public Stove()
    {
        textTimer = new Timer(100);
    }

    public void act()
    {
        setImage("img/Tiles/stove.png");
        //check if cat is touching stove and decrease lives by 1 if it is
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

    }
}
