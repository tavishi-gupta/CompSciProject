import mayflower.*;
public class Jack extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation walk;
    public Jack() 
    {   
        String[] str = new String[7];
        for (int i = 0; i < str.length; i++){
         str[i] = "img/jack/Walk (" + (i+1) + ").png";
        }
        
        walk = new Animation(50, str);
        walk.scale(200, 150);
        walk.setTransparency(50);
        setAnimation(walk);

    }
    public void act()
    {

        super.act();
        
        

    }
    
}
