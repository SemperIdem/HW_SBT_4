/**
 * Created by Gennady on 28.11.2016.
 */
public class Warlord implements Cloneable, Warrior {
    private int health;
    private int damage;
    private String name;
    private String squad;

    public Warlord(String name) {
        this.name=name;
        health=90;
        damage=15;
    }
    @Override
    public int attack() {
        return damage;
    }

    @Override
    public boolean isAlive() {
        return health>0;
    }

    @Override
    public void takeDamage(int damage) {
        health-=damage;
    }

    @Override
    public void setSquadName(String name) {
        squad=name;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Class: "+Warlord.class.getName()+" Squad:"+squad;
    }

    @Override
    public Warlord clone() throws CloneNotSupportedException {
        return (Warlord) super.clone();
    }
}
