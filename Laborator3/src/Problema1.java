import java.awt.*;

class Fractie {
    double numarator;
    double numitor;

    public Fractie(double numarator, double numitor){
        this.numarator = numarator;
        this.numitor = numitor;
    }

    public Fractie(){
        this(0,1);
    }

    private static double cmmmc(double a, double b){
        double aux;

        while(b > 0){
            aux = b;
            b = a % b;
            a = aux;
        }

        return a;
    }

    private static double cmmdc(double a, double b){
        return a * (b / cmmmc(a, b));
    }

    Fractie suma(Fractie a){
        Fractie b = new Fractie();

        b.numitor = cmmdc(numitor, a.numitor);

        b.numarator = numarator * (b.numitor / numitor);

        b.numarator += a.numarator * (b.numitor / a.numitor);

        return b;
    }

    public String toString(){
        return numarator + "/" + numitor;
    }

    public boolean equals(Object ob){
        if(this == ob)
            return true;

        if(ob == null || ob.getClass() != this.getClass())
            return false;

        return (((Fractie)ob).numitor == numitor && ((Fractie)ob).numarator == numarator);
    }

    public static void main(String[] args) {
        Fractie a = new Fractie();
        a.numarator = 4;
        a.numitor = 5;

        if(a.equals(new Fractie(4, 5))){
            System.out.println("true1");

        }
        else {
            System.out.println("false1");
        }

        if(a.equals(new Point(4, 5))){
            System.out.println("true2");
        }
        else {
            System.out.println("false2");
        }

        Fractie b = new Fractie(-3, 2);

        Fractie c = a.suma(b);

        System.out.println(a + "+" + b + "=" + c);
    }
}
