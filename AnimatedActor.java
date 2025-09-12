
import mayflower.*;
public class AnimatedActor extends GravityActor
{
    // instance variables - replace the example below with your own
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor()
    {
        animationTimer = new Timer(1000);
        
    }
    
    public void setAnimation (Animation a) {
        animation = a;
    }
    
    public void act()
    {
        super.act();
        if (animationTimer.isDone() ) {
            animationTimer.reset();
            MayflowerImage nextFrame = animation.getNextFrame();
            setImage(nextFrame);
            
        }
    }
}
