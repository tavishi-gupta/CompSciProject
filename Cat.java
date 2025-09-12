import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fallLeft;
    private Animation fallRight;
    private Animation jumpLeft;
    private Animation jumpRight;
    private int score;
    private int lives;
    private int scoreBound;
    
    public Cat() 
    {
        score = 0;
        scoreBound = 3;
        lives = 3;
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
        
        String[] jumpRightImg = new String[10];
        for (int i = 0; i < jumpRightImg.length; i++){
            jumpRightImg[i] = "img/cat/Jump (" + (i+1) + ").png";

        }
        String[] jumpLeftImg = new String[10];
        for (int i = 0; i < jumpLeftImg.length; i++){
            jumpLeftImg[i] = "img/cat/Jump (" + (i+1) + ").png";

        }
        
        jumpRight = new Animation(50, jumpRightImg);
        jumpRight.scale(100,87);
        jumpRight.setBounds(18,5,54,80);
        setJumpRightAnimation(jumpRight);
        
        jumpLeft = new Animation(50, jumpLeftImg);
        jumpLeft.scale(100,87);
        jumpLeft.mirrorHorizontally();
        jumpLeft.setBounds(28,5,54,80);
        setJumpLeftAnimation(jumpLeft);
        
        setAnimation(idle);
        
    }
    
    public void increaseScore(int amount) {
        score+=amount;
    }
    
    public void decreaseLives(int amount) {
        lives-=amount;
    }
    
    public void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Ingredients: " + score + "Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    public boolean Level1Complete() {
        if (score == scoreBound && lives > 0) {
            scoreBound = 5;
            score = 0;
            return true;
        }
        return false;
    }
    
    public boolean Level2Complete() {
        if (score == scoreBound && lives > 0) {
            return true;
        }
        return false;
    }
    
    public boolean Level3Complete() {
        if (score == 7 && lives > 0) {
            return true;
        }
        return false;
    }
    
    public void act()
    {
        
        super.act();
        if (Level1Complete()) {
            Mayflower.setWorld(new Level2());
        }
        
        //if (Level2Complete()) {
        //    Mayflower.setWorld(new Level3());
        //}
        
        if (Level3Complete()) {
            Mayflower.setWorld(new GameOverWin());
        }
        else {
            Mayflower.setWorld(new GameOverLose());
        }
        
        //walk.setTransparency(50);
        
    }
}
