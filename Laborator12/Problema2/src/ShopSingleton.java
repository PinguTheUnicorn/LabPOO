import java.util.ArrayList;

public class ShopSingleton {
    private static ShopSingleton shop  = null;
    public String name;
    public ArrayList<Product> products;

    private ShopSingleton(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public static ShopSingleton getInstance() {
        if(shop == null)
            shop = new ShopSingleton("Magazin");
        return shop;
    }

    public void showProducts() {
        System.out.println(products);
    }
}
