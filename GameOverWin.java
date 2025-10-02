import mayflower.*;

public class GameOverWin extends World {
    //this constructor sets up the background image and text for when player wins
    public GameOverWin() {
        setBackground("img/BG/BG1.png");
        showText("You win! Press space to play again.", 10, 30, Color.BLACK);
    }
    //directs player back to title screen when space is pressed
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new TitleScreen());
        }

    }
}