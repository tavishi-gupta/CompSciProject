import mayflower.*;

public class GameOverWin extends World {
    
    public GameOverWin() {
        setBackground("img/BG/BG1.png");
        showText("You win! Press space to play again.", 10, 30, Color.BLACK);
    }
    
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new TitleScreen());
        }
        
    }
}