public class Test {
    public static void main(String[] args) {
        IceCream iceCream = new Chocolate(new Vanilla(new BasicIceCream()));

        System.out.println(iceCream.getCost());
        System.out.println(iceCream.getDescription());
    }
}
