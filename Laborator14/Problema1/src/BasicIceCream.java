public class BasicIceCream implements IceCream {
    public BasicIceCream() {
        System.out.println("Adding cone\n");
    }

    @Override
    public String getDescription() {
        return "Ingredients: cone, ";
    }

    @Override
    public double getCost() {
        return 0.5;
    }
}
