public class Assistant extends User implements Element{
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof ScoreVisitor)
            visitor.visit(this);
    }
}
