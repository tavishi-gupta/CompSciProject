import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation fallingRight;
    private Animation fallingLeft;

    public Cat() 
    {   
        String[] walkImg = new String[10];
        for (int i = 0; i < walkImg.length; i++){
            walkImg[i] = "img/cat/Walk (" + (i+1) + ").png";

        }

        String[] idleImg = new String[10];
        for (int i = 0; i < idleImg.length; i++){
            idleImg[i] = "img/cat/Idle (" + (i+1) + ").png";

        }
        
        String[] idleLeftImg = new String[10];
        for (int i = 0; i < idleLeftImg.length; i++){
            idleLeftImg[i] = "img/cat/Idle (" + (i+1) + ").png";

        }

        String[] walkLeftImg = new String[10];
        for (int i = 0; i < walkLeftImg.length; i++){
            walkLeftImg[i] = "img/cat/Walk (" + (i+1) + ").png";

        }
        
        String[] fallingLeftImg = new String[8];
        for (int i = 0; i < fallingLeftImg.length; i++){
            fallingLeftImg[i] = "img/cat/Fall (" + (i+1) + ").png";

        }
        
        String[] fallingRightImg = new String[8];
        for (int i = 0; i < fallingRightImg.length; i++){
            fallingRightImg[i] = "img/cat/Fall (" + (i+1) + ").png";

        }

        walk = new Animation(50, walkImg);
        walk.scale(100,87);
        walk.setBounds(18,5,54,80);
        //walk.setTransparency(90);
        setWalkRightAnimation(walk);

        idle = new Animation(50, idleImg);
        idle.scale(100,87);
        idle.setBounds(18,5,54,80);
        setIdleAnimation(idle);
        
        idleLeft = new Animation(50, idleLeftImg);
        idleLeft.scale(100,87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28,5,54,80);
        setIdleLeftAnimation(idleLeft);

        walkLeft = new Animation(50, walkLeftImg);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28,5,54,80);
        setWalkLeftAnimation(walkLeft);
        
        fallingLeft = new Animation(50, fallingLeftImg);
        fallingLeft.scale(100,87);
        fallingLeft.mirrorHorizontally();
        fallingLeft.setBounds(28,5,54,80);
        setFallingLeftAnimation(fallingLeft);
        
        fallingRight = new Animation(50, fallingRightImg);
        fallingRight.scale(100,87);
        fallingRight.mirrorHorizontally();
        fallingRight.setBounds(28,5,54,80);
        setFallingRightAnimation(fallingRight);
        
        
        setAnimation(idle);
    }

    public void act()
    {

        super.act();


    }
}
