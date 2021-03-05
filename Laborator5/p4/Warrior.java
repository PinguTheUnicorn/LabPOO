public class Warrior {
    //0 = dead, 100 = full strength
    public int health;
    public String name;

    //constructor
    public Warrior (int health, String name) {
        this.health = health;
        this.name = name;
    }

    //metoda pentru getDamage ce va fi supra-scrisa
    public int getDamage(){
        return 2;
    }

    //metoda pentru a converti in string
    public String toString() {
        return name;
    }
}

class Snake extends Warrior {
    //constructor
    public Snake(int health, String name) {
        super(health, name);
    }

    //metoda ce intoarce damage-ul pentru clasa Snake
    public int getDamage() {
        return 10;
    }
}

class Ogre extends Warrior {
    //constructor
    public Ogre(int health, String name) {
        super(health, name);
    }

    //metoda ce intoarce damage-ul pentru clasa Ogre
    public int getDamage() {
        return 6;
    }
}

class Marshmallow_Man extends Warrior {
    //constructor
    public Marshmallow_Man(int health, String name) {
        super(health, name);
    }

    //metoda ce intoarce damage-ul pentru clasa Marshmallow_Man
    public int getDamage() {
        return 1;
    }
}
