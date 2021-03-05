public class Food  extends Product{
    public Food(String name, float price) {
        super(name, price);
    }

    @Override
    public float getPricedReduced() {
        return price * 0.8f;
    }

    public String toString() {
        return "food " + super.toString();
    }
}
