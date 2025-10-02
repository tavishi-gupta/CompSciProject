import mayflower.*;

public class GameOverLose extends World {
    //this constructor sets up the background image and text for when player loses
    public GameOverLose() {
        setBackground("img/BG/BG1.png");
        showText("Oh no! You lost all your lives. \n To restart press Space.", 10, 30, Color.BLACK);
    }
    //resets to level 1 when the game is lost
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            Mayflower.setWorld(new Level1());
        }
    }
}