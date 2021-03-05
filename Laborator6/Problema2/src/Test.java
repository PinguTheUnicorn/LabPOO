public class Test {
    public static void main(String[] args) {
        //Conversie 1
        Circle c1 = new Circle();
        Square sq;// = (Square) c1; nu face parte din aceeasi ramura de derivare

        //Conversie 2
        Rectangle r = /*new Rectangle(5.0, 5.0);*/ new Square(5.0);
        sq = (Square) r; //downcasting, ClassCastException
        System.out.println(sq);

        //Conversie 3
        sq = new Square(7.0); //upcasting, este implicit
        r = sq;
        System.out.println(r);
    }
}
