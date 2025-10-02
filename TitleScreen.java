import mayflower.*;
public class TitleScreen extends World
{

    public TitleScreen()
    {
        setBackground("img/BG/BG1.png");
        showText("Welcome to Kitchen Mania! Press Space to begin.", 10, 30, Color.BLACK);
    }

    public void act() {
        //set world to level 1 when space is pressed from title screen
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new Level1());
        }
    }
}