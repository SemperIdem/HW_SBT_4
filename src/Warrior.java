/**
 * Created by Gennady on 28.11.2016.
 */
public interface Warrior {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    Warrior clone() throws CloneNotSupportedException;
}
