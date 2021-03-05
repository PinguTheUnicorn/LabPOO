public class ProductFactory {
    public static Product factory(String type, String nameProduct,
                           float productPrice) {
        switch (type) {
            case "book": return new Book(nameProduct, productPrice);
            case "food": return new Food(nameProduct, productPrice);
            case "baverage": return new Beverage(nameProduct,
                    productPrice);
            case "computer": return new Computer(nameProduct,
                    productPrice);
        }

        return null;
    }
}
