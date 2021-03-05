public abstract class ToppingDecorator implements IceCream{
    protected IceCream iceCream;

    public ToppingDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}
