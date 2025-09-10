import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fallLeft;
    private Animation fallRight;
    
    public Cat() 
    {
        String [] walkName = new String[10];
        for (int i = 0; i < walkName.length; i++) {
            walkName[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        walkRight = new Animation(50, walkName);
        setWalkRightAnimation(walkRight);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);
        
        
        String [] idleName = new String[10];
        for (int i = 0; i < idleName.length; i++) {
            idleName[i] = "img/cat/Idle (" + (i+1) + ").png";
        }
        idle = new Animation(50, idleName);
        setIdleAnimation(idle);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        String [] walkLeftName = new String[10];
        for (int i = 0; i < walkLeftName.length; i++) {
            walkLeftName[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        walkLeft = new Animation(50, walkLeftName);
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(100, 87);
        walkLeft.setBounds(10, 5, 54, 80);
        walkLeft.mirrorHorizontally();
        
        String[] fallName = new String[10];
        for (int i = 0; i < fallName.length; i++) {
            fallName[i] = "img/cat/Fall (" + (i+1) + ").png";
        }
        fallLeft = new Animation(50, fallName);
        setFallLeftAnimation(fallLeft);
        fallLeft.mirrorHorizontally();
        fallLeft.scale(100, 87);
        fallLeft.setBounds(28, 5, 54, 80);
        
        fallRight = new Animation(50, fallName);
        setFallRightAnimation(fallRight);
        fallRight.scale(100, 87);
        fallRight.setBounds(18, 5, 54, 80);
        
        idleLeft = new Animation(50, idleName);
        setIdleLeftAnimation(idleLeft);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(100, 87);
        idleLeft.setBounds(28, 5, 54, 80);
        
        setAnimation(idle);
        
    }
    public void act()
    {
        
        super.act();
        
        //walk.setTransparency(50);
        
    }
}
