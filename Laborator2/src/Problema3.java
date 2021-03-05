import java.util.*;

public class Problema3 {
    public int ran(int min, int max){
        Random nr = new Random();
        return nr.nextInt(max - min) + min;
    }

    public int stergere(Vector v, int x){
        Object cautat = x;
        boolean ok;
        int aparitie = 0;

        ok = v.remove(cautat);

        while(ok){
            aparitie++;
            ok = v.remove(cautat);
        }

        return aparitie;
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        Problema3 obiect = new Problema3();

        int i, suma = 0;

        for(i = 0; i < 20; i++){
            v.add(obiect.ran(0,11));
        }

        Object maxim = Collections.max(v);
        System.out.println("Elementul maxim este " + maxim);
        Object minim = Collections.min(v);
        System.out.println("Pozitia elementului minim este " + v.indexOf(minim));

        for(i = 0; i < v.size(); i++){
            suma += v.get(i);
        }
        System.out.println("Media elementelor vectorului este " + (suma / v.size()));

        System.out.println(obiect.stergere(v, 0));
        System.out.println(v);
    }
}
