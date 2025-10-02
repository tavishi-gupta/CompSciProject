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
    private Animation climb;
    private int score;
    private int lives;
    private int scoreBound;
    private int level;

    public Cat() 
    {
        //initialize variables to level 1 values
        score = 3;
        lives = 3;
        level = 1;
        
        //create string arrays for animations
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

        String[] jumpRightImg = new String[8];
        for (int i = 0; i < jumpRightImg.length; i++){
            jumpRightImg[i] = "img/cat/Jump (" + (i+1) + ").png";

        }
        String[] jumpLeftImg = new String[8];
        for (int i = 0; i < jumpLeftImg.length; i++){
            jumpLeftImg[i] = "img/cat/Jump (" + (i+1) + ").png";

        }
        
        String [] climbName = new String[10];
        for (int i = 0; i < climbName.length; i++) {
            climbName[i] = "img/cat/Climb (" + (i+1) + ").png";
        }

        //create animations
        walkRight = new Animation(50, walkImg);
        walkRight.scale(100,87);
        walkRight.setBounds(18,5,54,80);
        setWalkRightAnimation(walkRight);

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

        fallLeft = new Animation(50, fallingLeftImg);
        fallLeft.scale(100,87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28,5,54,80);
        setFallLeftAnimation(fallLeft);

        fallRight = new Animation(50, fallingRightImg);
        fallRight.scale(100,87);
        fallRight.setBounds(18,5,54,80);
        setFallRightAnimation(fallRight);

        jumpRight = new Animation(50, jumpRightImg);
        jumpRight.scale(100,87);
        jumpRight.setBounds(18,5,54,80);
        setJumpRightAnimation(jumpRight);

        jumpLeft = new Animation(50, jumpLeftImg);
        jumpLeft.scale(100,87);
        jumpLeft.mirrorHorizontally();
        jumpLeft.setBounds(28,5,54,80);
        setJumpLeftAnimation(jumpLeft);

        climb = new Animation(50, climbName);
        setClimbAnimation(climb);
        climb.scale(100, 87);
        climb.setBounds(18, 5, 54, 80);

        setAnimation(idle);

    }

    public void increaseScore(int amount) {
        score+=amount;
    }

    public void decreaseScore(int amount){
        score-= amount;   
    }

    public void decreaseLives(int amount) {
        lives-=amount;
    }
    
    //to update text when score or lives change
    public void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Ingredients: " + score + "Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    //check if level 1 is complete
    public boolean Level1Complete() {
        if (score == 0 && lives > 0 && level == 1) {
            level++;
            return true;
        }
        return false;
    }
    
    //check if level 2 is complete
    public boolean Level2Complete() {
        if (score == 0 && lives > 0  && level == 2) {

            level++;
            return true;
        }
        return false;
    }
    
    //check if level 3 is complete
    public boolean Level3Complete() {
        if (score == 0 && lives > 0 && level == 3) {
            level++;
            return true;
        }
        return false;
    }
    
    //check if game is over (all lives have been lost)
    public boolean GameOver() {
        if (lives <= 0) {
            return true;
        }
        return false;
    }

    public void act()
    {

        super.act();
        //switch levels
        if (Level1Complete()) {
            increaseScore(5);
            Mayflower.setWorld(new Level2(this));
            updateText();

        }

        else if (Level2Complete()) {
            increaseScore(7);
            Mayflower.setWorld(new Level3(this));
            updateText();
        }

        else if (Level3Complete()) {
            Mayflower.setWorld(new GameOverWin());
        }

        if (GameOver()) {
            Mayflower.setWorld(new GameOverLose());
        }


    }
}
