import mayflower.*;
public class Ninja extends AnimatedActor
{
    private Animation walk;
    public Ninja() 
    {   
        String[] str = new String[7];
        for (int i = 0; i < str.length; i++){
         str[i] = "img/ninjagirl/Attack__00" + (i+1) +".png";
        }
        
        walk = new Animation(50, str);
        walk.scale(100, 87);
        walk.setTransparency(70);
        setAnimation(walk);

    }
    public void act()
    {

        super.act();
        
        

    }
}
