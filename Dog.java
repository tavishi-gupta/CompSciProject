import mayflower.*;

public class Dog extends AnimatedActor
{

    private Animation walk;
    public Dog() 
    {   
        String[] str = new String[10];
        for (int i = 0; i < str.length; i++){
         str[i] = "img/dog/Walk (" + (i+1) + ").png";
        }
        
        walk = new Animation(50, str);
        walk.scale(150, 118);
        walk.setTransparency(20);
        setAnimation(walk);

    }
    public void act()
    {

        super.act();
        
        

    }
}