class Produs{
    String nume;
    double pret;
    int cant;

    Produs(String a, double b, int c){
        nume = a;
        pret = b;
        cant = c;
    }

    Produs(){
        this("produs_fara_nume", 0, 0);
    }

    public String toString(){
        return "Produs: " + nume + " " + pret + " " + cant;
    }

    public double getTotalProdus(){
        return pret * cant;
    }
}

class Magazin{
    String nume;
    private Produs[] marfa = new Produs[3];

    Magazin(String nume, Produs ...marfa){
        this.nume = nume;
        int i;
        for(i = 0; i < marfa.length; i++){
            this.marfa[i] = marfa[i];
        }
    }

    public String toString(){
        int i;
        String rezultat = "";

        for(i = 0; i < marfa.length - 1; i++){
            rezultat += marfa[i].toString() + "\n";
        }

        rezultat += marfa[marfa.length - 1].toString();

        return rezultat;
    }

    public double getTotalMagazin(){
        double rezultat = 0;
        int i;

        for(i = 0; i < marfa.length; i++){
            rezultat += marfa[i].getTotalProdus();
        }

        return rezultat;
    }
}

class MainP2 {
    public static void main(String[] args) {
        Magazin shop = new Magazin("Pingu S.R.L.", new Produs("Laptop", 99.99, 100),
                new Produs("Lapte", 5.99, 10), new Produs("cartof", 0.99, 200));

        System.out.println(shop.getTotalMagazin() + "\n" + shop);
    }
}
