public class Computer extends Product {

    public Computer(String name, float price) {
        super(name, price);
    }

    @Override
    public float getPricedReduced() {
        return price * 0.9f;
    }

    public String toString() {
        return "computer " + super.toString();
    }
}
