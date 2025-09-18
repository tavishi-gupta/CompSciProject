import mayflower.*;
public class CooldownActor extends Actor
{
    boolean invulnerable;
    Timer invulnerableTimer;

    public CooldownActor()
    {
        invulnerableTimer = new Timer(1000000);
        invulnerable = false;
    }

    public void act(){

    }

    public void setInvulnerable(){
        invulnerable = true;
        invulnerableTimer.reset();

    }

    public boolean isInvulnerable(){
        if (invulnerableTimer.isDone()){
            invulnerable = false;

        }
        return invulnerable;

    }
}
