public class Pensionar {
    private int aniVechime;
    private float salariu;
    private Strategy strategy;

    public Pensionar(int aniVechime, float salariu) {
        this.aniVechime = aniVechime;
        this.salariu = salariu;

        if(20 <= aniVechime && aniVechime < 30)
            strategy = new TwentyStrategy();
        if(30 <= aniVechime && aniVechime < 40)
            strategy = new ThirtyStrategy();
        if(40 <= aniVechime)
            strategy = new FortyStrategy();
    }

    public float getPensie() {
        return strategy.calcul(aniVechime, salariu);
    }

    public static void main(String[] args) {
        Pensionar mamaia = new Pensionar(24, 3200.55f);
        Pensionar tataie = new Pensionar(35, 4500f);
        Pensionar strbunicul = new Pensionar(49, 6100.99f);

        System.out.println(mamaia.getPensie());
        System.out.println(tataie.getPensie());
        System.out.println(strbunicul.getPensie());
    }
}
