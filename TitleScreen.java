import mayflower.*;
public class TitleScreen extends World
{
    
    public TitleScreen()
    {
        // initialise instance variables
        setBackground("img/BG/BG1.png");
        showText("Welcome to Kitchen Mania! Press Space to begin.", 10, 30, Color.BLACK);
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new Level1());
        }
    }
}