public abstract class Repository {
    private String name;

    public String getName() {
        return name;
    }

    public abstract void accept(Visitor f);
}
