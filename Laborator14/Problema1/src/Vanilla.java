public class Vanilla extends ToppingDecorator {
    public Vanilla(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding vanilla\n");
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "vanilla, ";
    }

    @Override
    public double getCost() {
        return iceCream.getCost() + 2;
    }
}
