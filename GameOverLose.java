import mayflower.*;
public class GameOverLose extends World
{
    
    public GameOverLose()
    {
        // initialise instance variables
        setBackground("img/BG/BG1.png");
        showText("Too bad, you lose :(", 10, 30, Color.BLACK);
    }

    public void act() {
        
    }
}