class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram() {
        this(0,0,0,0);
    }

    public Paralelogram(int latura1, int latura2, double  unghi1, double unghi2) {
        super(latura1, latura2, latura1, latura2, unghi1, unghi2, unghi1, unghi2);
    }

    public Paralelogram(int latura1, int latura2) {
        this(latura1, latura2, 0,0);
    }

    public Paralelogram(double unghi1, double unghi2) {
        this(0,0,unghi1, unghi2);
    }

    public double arie() {
        return latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
    }
}

class Romb extends Paralelogram {
    public int diagonal1, diagonal2;

    public Romb() {
        this(0, 0);
    }

    public Romb(int latura, int diagonal1, int diagonal2, double unghi1, double unghi2) {
        super(latura, latura, unghi1, unghi2);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public Romb(int latura, int diagonal1, int diagonal2) {
        this(latura, diagonal1, diagonal2, 0, 0);
    }

    public Romb(double unghi1, double unghi2) {
        this(0, 0, 0, unghi1, unghi2);
    }

    public double arie() {
        return (diagonal1 * diagonal2) / 2;
    }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi() {
        this(0, 0);
    }

    public Dreptunghi(int latime, int lungime) {
        super(lungime, latime, 90.00, 90.00);
    }

    public double arie() {
        return latura1 * latura2;
    }
}

class Patrat extends Dreptunghi {
    public Patrat() {
        super(0, 0);
    }

    public Patrat(int latura) {
        super(latura, latura);
    }

    public double arie() {
        return super.arie();
    }
}

public class Problema1 {
    public static void main(String[] args) {
        Paralelogram p1 = new Paralelogram(1, 2, 35, 145);
        Romb r1 = new Romb(12, 16, 12);
        Dreptunghi d1 = new Dreptunghi(12, 1);
        Patrat p2 = new Patrat(4);

        System.out.println(p1.arie());
        System.out.println(r1.arie());
        System.out.println(d1.arie());
        System.out.println(p2.arie());
    }
}