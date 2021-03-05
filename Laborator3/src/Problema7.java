class ClockTime{
    private int hour;
    private int minute;

    //se construieste obiectul, folosindu-se de argumentele primite
    ClockTime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    //intoarce diferenta dintre doua momente de timp, in minute
    public int getDifference(ClockTime arrival){
        int hour, minute;
        hour = 24 - this.hour + arrival.hour; //se face diferenta dintre ore
        minute = 60 - this.minute + arrival.minute; //se face diferenta dintre minute

        //se intoarce durata, transformata in minute
        return hour * 60 + minute;
    }

    public String toString(){
        return hour + ":" + minute;
    }
}

class Schedule{
    ClockTime departure;
    ClockTime arrival;

    //se construiesc elementele, folosindu-se constructorii anteriori
    Schedule(ClockTime departure, ClockTime arrival){
        this.departure = departure;
        this.arrival = arrival;
    }

    Schedule(int h1, int m1, int h2, int m2) {
        this(new ClockTime(h1, m1), new ClockTime(h2, m2));
    }

    /*pentru ca nu se pot accesa datele direct, se intoarce diferenta de timp
    folosindu-se metoda din clasa ClockTime
     */
    public int durata(){
        return departure.getDifference(arrival);
    }
}

class Route{
    String origin;
    String destination;

    //se construieesc elementele
    Route(String origin, String destination){
        this.origin = origin;
        this.destination = destination;
    }

    /*se verifica daca destinatia de la prima ruta este aceeasi
    cu statia de plecarea de la cealalta ruta si viceversa
     */
    public boolean verificare(Route drum){
        return (origin == drum.destination && destination == drum.origin);
    }
}

class Train{
    Route r;
    Schedule s;
    boolean local;

    //folosindu-se constructorii anteriori, se creaza obiectul de clasa Train
    Train(String[] route, int[] hour, int[] minute, boolean local){
        r = new Route(route[0], route[1]);
        s = new Schedule(new ClockTime(hour[0], minute[0]), new ClockTime(hour[1], minute[1]));
        this.local = local;
    }

    //se calculeaza pretul in functie de formula data
    public int getPrice(){
        if(local){
            return s.durata();
        }
        else {
            return 2 * s.durata();
        }
    }

    /*se formeaza String-ul dupa template-ul dat in exercitiu,
    adaugandu-se si pretul la final
     */
    public String toString(){
        String rezultat = "";

        if(local){
            rezultat += "local | ";
        }
        else {
            rezultat += "in afara | ";
        }

        rezultat += r.origin + " ";
        rezultat += "(" + s.departure + ")" + " -> ";
        rezultat += r.destination + " " + "(" + s.arrival + ")" + " | ";
        rezultat += "Price: " + this.getPrice() + " lei";

        return rezultat;
    }
}

class MainP7{
    public static void main(String[] args) {
        String[] rute = {"Bucuresti Nord", "Constanta"};
        int[] hour = {11, 14};
        int[] minute = {41, 24};
        boolean local = true;
        Train cfr = new Train(rute, hour, minute, local);
        System.out.println("[local] [origin (departure)] -> [destination (arrival)]  [price(in lei)]");
        System.out.println(cfr);
    }
}
