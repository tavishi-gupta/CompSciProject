
import mayflower.*;
public class Animation
{
    // instance variables - replace the example below with your own
    private int framerate;
    private int currentFrame;
    private MayflowerImage[] frames;

    /**
     * Constructor for objects of class Animation
     */
    public Animation(int num, String[] y)
    {
        // initialise instance variables
        framerate = num;
        currentFrame = 0;
        frames = new MayflowerImage[10];
        for (int i = 0; i < y.length; i++) {
            frames[i] = new MayflowerImage(y[i]);
        }
        
    }
    
    public void setBounds(int x, int y, int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].crop(x, y, w, h);
        }  
    }
    
    public int getFrameRate() {
        return framerate;
    }
    
    public void scale(int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally() {
        for (int i = 0; i < frames.length; i++) {
            frames[i].mirrorHorizontally();
        }
    }
    
    public MayflowerImage getNextFrame() {
        if (currentFrame%frames.length == 0) {
            currentFrame = 0;
        }
        MayflowerImage image = frames[currentFrame];
        currentFrame += 1;
        return image;
    }
}
