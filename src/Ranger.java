/**
 * Created by Gennady on 28.11.2016.
 */
public class Ranger implements Warrior,Cloneable {
    private int health;
    private int damage;
    private String name;
    private String squad;

    public Ranger(String name) {
        this.name=name;
        health=80;
        damage=20;
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
        return "Name: "+name+" Class: "+Ranger.class.getName()+" Squad:"+squad;
    }

    @Override
    public Ranger clone() throws CloneNotSupportedException {
        return (Ranger) super.clone();
    }

}
