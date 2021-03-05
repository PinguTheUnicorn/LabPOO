import java.util.logging.SocketHandler;

public class Test {
    public void addProduct(Product product) {
        ShopSingleton.getInstance().products.add(product);
    }

    public void removeProduct(Product product) {
        ShopSingleton.getInstance().products.remove(product);
    }

    public Product getCheapestProduct() {
        Product prodMin = ShopSingleton.getInstance().products.get(0);
        for (Product produs:
             ShopSingleton.getInstance().products) {
            if(prodMin.price > produs.price) {
                prodMin = produs;
            }
        }

        return prodMin;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Product cv2 = ProductFactory.factory("book", "ceva2", 9.09f);

        test.addProduct(ProductFactory.factory("baverage", "ceva1", 12.5f));
        test.addProduct(cv2);
        test.addProduct(ProductFactory.factory("computer", "altceva2", 8f));
        test.addProduct(ProductFactory.factory("food", "inca ceva", 8.99f));

        ShopSingleton.getInstance().showProducts();
        test.removeProduct(cv2);

        ShopSingleton.getInstance().showProducts();

        System.out.println(test.getCheapestProduct());

        System.out.println(ShopSingleton.getInstance().products
                .get(0).getPricedReduced());
    }
}
