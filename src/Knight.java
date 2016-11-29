/**
 * Created by Gennady on 28.11.2016.
 */
public class Knight implements Warrior,Cloneable {
    private int health;
    private int damage;
    private String name;
    private String squad;


    public Knight(String name) {
        this.name=name;
        health=130;
        damage=10;
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
        return "Name: "+name+" Class: "+Knight.class.getName()+" Squad:"+squad;
    }

    @Override
    public Knight clone() throws CloneNotSupportedException {
        return (Knight) super.clone();
    }


}
