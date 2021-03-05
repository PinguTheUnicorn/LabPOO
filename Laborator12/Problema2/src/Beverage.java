public class Beverage extends Product {

    public Beverage(String name, float price) {
        super(name, price);
    }

    @Override
    public float getPricedReduced() {
        return price * .95f;
    }

    public String toString() {
        return "baverage " + super.toString();
    }
}
