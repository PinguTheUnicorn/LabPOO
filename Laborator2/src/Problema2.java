import java.util.*;
public class Problema2 {
    public int numarAparitie1(String sir1, String sir2){
        String sirAparitie[];
        sirAparitie = sir1.split(" "); //se imparte sirul 1 folosind metoda split
        int i, aparitie = 0;

        //se parcurgurge array-ul si se verifica elementele sunt egale cu sirul cautat
        for(i = 0 ;i < sirAparitie.length; i++)
            if(sirAparitie[i].equals(sir2)) aparitie++;

        return aparitie;
    }

    public int numarAparitie2(String sir1, String sir2){
        //se formeaza un obiect de clasa StringTokenizer folosind delimitatoarele date
        StringTokenizer tokens = new StringTokenizer(sir1, ":,.-? \n");
        String test;
        int aparitie = 0;

        //se ia fiecare element si se compara cu sirul cautat
        while(tokens.hasMoreElements()){
            test = tokens.nextToken();
            if(sir2.equals(test)){
                aparitie++;
            }
        }

        return aparitie;
    }

    public static void main(String[] args) {
        String sir1 = new String("sir1 si sir2 sunt 2 siruri");
        String sir2 = new String("sir2"); //Testat cu sir intoarce '0' pentru prima varianta

        Problema2 obiect = new Problema2();

        System.out.println(obiect.numarAparitie1(sir1, sir2));

        String sir3 = new String("Marius, de ce nu l-ai ajutat pe George? Era de datoria ta sa vezi ce poti face.");

        System.out.println(obiect.numarAparitie2(sir3, "ce"));
        System.out.println(obiect.numarAparitie2(sir3, "l"));
    }
}
