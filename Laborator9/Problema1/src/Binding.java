public class Binding{
    public static void main(String args[]) {
        Hero h1 = new Warrior(), h2 = new Ninja();
        Hero h3 = new Rogue();
        BadLuck bl = new StormFire();
        bl.execute(h1);
        bl.execute(h2);
        bl.execute(h3);
    }
}

abstract class Hero {
    public abstract void heroMethod();
}

class Warrior extends Hero{
    public void heroMethod() {
    }
}

class Ninja extends Hero{
    public void heroMethod() {
    }
}

class Rogue extends Hero{
    public void heroMethod() {
    }
}

abstract class BadLuck {
    abstract void execute(Hero h);
    abstract void execute(Warrior w);
    abstract void execute(Ninja n);
    abstract void execute(Rogue r);
}

class StormFire extends BadLuck {
    @Override
    void execute(Hero h) {
    }

    @Override
    void execute(Ninja n) {
    }

    @Override
    void execute(Rogue r) {
    }

    @Override
    void execute(Warrior w) {
    }
}
