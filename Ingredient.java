
import mayflower.*;

public class Ingredient extends Actor
{
    public Ingredient()
    {
        //setImage("img/yarn.png");
        //this.scale(50, 50);
    }

    public void act(){
        //remove ingredient once cat touches it
        if (isTouching(Cat.class)) {
            World w = getWorld();
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            w.removeObject(this);
            //update the score
            c.decreaseScore(1);
            c.updateText();
        }
    }
}