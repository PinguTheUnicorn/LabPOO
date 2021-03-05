import java.util.*;
public class Problema5 {
    public String cenzurare(String text, String[] cuvinte){
        int i;
        boolean afisare = false;
        String text_modificat;
        String cenzura;

        //se iau toate cuvintele dorite sa se cenzureze si se verifica daca exista in text
        for(i = 0; i < cuvinte.length; i++){
            if(text.contains(cuvinte[i])){
                //in caz afirmativ, se va afisa mesajul de gasire daca nu s-a intamplat inca
                if(!afisare){
                    System.out.println("Text suspect");
                    afisare = true;
                }

                //daca este gasit un cuvant de cenzurat, se aplica procedeul de cenzura pentru toate aparitiile acestuia
                while(text.contains((cuvinte[i]))){
                    //se creaza cenzura cat sa fie vizibile doar prima si ultima litera
                    cenzura = String.join(" ", Collections.nCopies(cuvinte[i].length() - 2, "*"));
                    //se ia prima parte a textului pana la inceperea cuvantului
                    text_modificat = text.substring(0, text.indexOf(cuvinte[i]) + 1);
                    //se adauga cenzura si restul textului la obiectul auxiliar
                    text_modificat += cenzura + text.substring(text.indexOf(cuvinte[i]) + cuvinte[i].length() - 1);
                    //textul modificat devine textul oficial
                    text = text_modificat;
                }
            }
        }

        //daca nu a fost gasit nicun cuvant de cenzurat, se afiseaza mesajul corespunzator
        if(!afisare){
            System.out.println("Nimic suspect");
        }

        return text;
    }

    public static void main(String[] args) {
        String text = "Un terorist avea o bomba";
        String cuvinte[] = new String[2];

        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";

        Problema5 prb5 = new Problema5();
        String rezultat;

        rezultat = prb5.cenzurare(text, cuvinte);

        System.out.println(rezultat);
    }
}
