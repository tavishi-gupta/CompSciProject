
import mayflower.*;

public class Ingredient extends Actor
{
    public Ingredient()
    {
        //setImage("img/yarn.png");
        //this.scale(50, 50);
    }
    
    public void act(){
        if (isTouching(Cat.class)) {
            World w = getWorld();
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            w.removeObject(this);
            c.decreaseScore(1);
            c.updateText();
        }
    }
}