public class Book extends Product {
    public Book(String name, float price) {
        super(name, price);
    }

    @Override
    public float getPricedReduced() {
        return price * 0.85f;
    }

    public String toString() {
        return "book " + super.toString();
    }
}
