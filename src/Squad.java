import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Gennady on 28.11.2016.
 */
public class Squad implements Cloneable {
    private ArrayList<Warrior> squad;
    private String squadName;

    //лишние пустые строки
    public Squad(String str) {
        squadName=str;
        squad = new ArrayList<Warrior>();//второй раз тип указывать не обязательно, можно просто new ArrayList<>();
    }

    public Squad(String str,ArrayList<Warrior> sq) {
        squadName=str;
        squad=sq;
    }

    public boolean hasAliveWarriors() {
        for (Warrior fighter :squad) {
            if (fighter.isAlive())
                return true;
        }
        return false;
    }

    public Warrior getRandomWarrior() throws NotLiveWarriorException {
        if(!hasAliveWarriors())
            throw new NotLiveWarriorException("Живые бойцы отсутствуют");
        ArrayList<Warrior> liveWars = new ArrayList<Warrior>();
        for (Warrior fighter : squad) {
            if(fighter.isAlive()) {
                liveWars.add(fighter);//не самое лучшее решение. если создадим млн бойцов, потом будем копировать млн ссылок?
            }
        }
        return liveWars.get(new Random().nextInt(liveWars.size()));
    }

    @Override
    public String toString() {
        return "Squad name: "+squadName;
    }

    public void addFighter(Warrior fighter) {
        fighter.setSquadName(squadName);
        squad.add(fighter);
    }
    public void setSquadName(String str) {
        squadName=str;
        if(squad!=null) {//то есть мы принимаем null как допустимый аргумент, но с бойцами ничего не делаем. почему?
            for(Warrior fighter : squad ) {
                fighter.setSquadName(str);
            }
        }
    }

    public String getSquadName() {
        return squadName;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad result = (Squad) super.clone();
        result.squad=new ArrayList<Warrior>(squad.size());
        for(Warrior fighter : squad )
            result.squad.add(fighter.clone());
        return result;
    }
}
