import mayflower.*;
/**
 * Write a description of class Animation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animation
{
    // instance variables - replace the example below with your own
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;

    public Animation(int fr, String[] files){
        framerate =  fr;
        currentFrame = 0;
        frames = new MayflowerImage[files.length];
        for (int i = 0; i < frames.length; i ++){
            frames[i] = new MayflowerImage(files[i]);
        }

    }

    public int getFrameRate() {
        return framerate;
    }

    public MayflowerImage getNextFrame(){

        MayflowerImage img = frames[currentFrame];
        currentFrame ++;
        if ( currentFrame == frames.length){
            currentFrame = 0;  
        }
        return img;
    }

    public void scale (int w, int h){
        for (int i = 0; i < frames.length; i++){
            frames[i].scale(w, h);
        }
    }

    public void setTransparency(int percent){
        for (int i = 0; i < frames.length; i++){
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally(){
        for (int i = 0; i < frames.length; i++){
            frames[i].mirrorHorizontally();
        }
    }
    public void setBounds(int x, int y, int w, int h){
        for (int i = 0; i < frames.length; i++){
            frames[i].crop(x, y, w, h);
        }
    }
}
