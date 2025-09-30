import mayflower.*;

public class GameOverLose extends World {
    
    public GameOverLose() {
        setBackground("img/BG/BG1.png");
        showText("Oh no! You lost all your lives. \n To restart press Space.", 10, 30, Color.BLACK);
    }
    
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new Level1());
        }
    }
}
