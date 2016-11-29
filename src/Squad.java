import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Gennady on 28.11.2016.
 */
public class Squad implements Cloneable {
    private ArrayList<Warrior> squad;
    private String squadName;


    public Squad(String str) {
        squadName=str;
        squad = new ArrayList<Warrior>();
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
            throw new NotLiveWarriorException("Живые бойцы отсутсвуют");
        ArrayList<Warrior> liveWars = new ArrayList<Warrior>();
        for (int i=0;i<squad.size();i++) {
            if(squad.get(i).isAlive()) {
                liveWars.add(squad.get(i));
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
        if(squad!=null) {
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
