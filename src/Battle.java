/**
 * Created by Gennady on 29.11.2016.
 */
public class Battle {
    public static void main(String args[]) throws CloneNotSupportedException, NotLiveWarriorException {
        Squad humans = new Squad("Humans");
        int count=4;
        for (int i =1; i<=count;i++) {
            humans.addFighter(new Warlord("Warlord #"+i));
            humans.addFighter(new Ranger("Ranger #"+i));
            humans.addFighter(new Knight("Knight #"+i));
        }
        Squad orcs = humans.clone();
        orcs.setSquadName("Orcs");

        DataHelper data = new DataHelper();
        System.out.println("Battle started at "+data.getFormattedStartDate());
        while(orcs.hasAliveWarriors() && humans.hasAliveWarriors()) {
            Warrior human = humans.getRandomWarrior();
            Warrior orc=orcs.getRandomWarrior();
            orc.takeDamage(human.attack());
            if(!orcs.hasAliveWarriors())
                break;
            data.skipTime();
            human.takeDamage(orc.attack());
        }
        System.out.println("Battle ending at "+data.getFormattedFinishDate());
        System.out.println(data.getFormattedDiff());
        if (orcs.hasAliveWarriors())
            System.out.println(orcs.getSquadName()+" won!!!");
        else
            System.out.println(humans.getSquadName()+" won!!!");
    }
}
