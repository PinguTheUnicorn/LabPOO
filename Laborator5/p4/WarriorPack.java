import java.util.*;

public class WarriorPack {
    private Vector<Warrior> warriors ;

    //constructor
    public WarriorPack () {
        warriors = new Vector<Warrior>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector getWarriors() {
        return warriors ;
    }

    //metoda ce intoarce forma string
    public String toString() {
        String rezultat = "";

        for(int i = 0; i < warriors.size(); i++) {
            rezultat += warriors.get(i) + " ";
        }

        return rezultat;
    }

    //metoda ce intoarce daunele totale
    public int calculateDamage() {
        int damage = 0;
        //pentru fiecare warrior din grup
        for (int i = 0; i < warriors.size(); i++) {
            //se intoarce valoarea daunelor fiecarui warrior
            damage += ((Warrior)warriors.get(i)).getDamage();
        }

        return damage;
    }

    //metoda main creata pentru testare
    public static void main(String[] args) {
        WarriorPack hoarda = new WarriorPack();
        hoarda.addWarrior(new Snake(30, "Best Friend"));
        hoarda.addWarrior(new Ogre(100, "Lord Cromwell"));
        hoarda.addWarrior(new Marshmallow_Man(20, "Stay Puft"));

        System.out.println(hoarda.calculateDamage());
    }
}
