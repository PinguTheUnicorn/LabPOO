public class Problema1 {
    public static void main(String[] args) {
        String sir1 = new String("si");
        String sir2 = new String("sir1 si cu sir2 fac un sir3");
        int i, aparitie = 0; //se initializeaza numarul de aparitii cu 0

        for(i = 0; i < sir2.length() - sir1.length(); i++){ //se parcurge sirul 2
            /*daca de la pozitia i pana la i + lungimea lui sir1
            se gaseste un sir care sa fie egal cu sir1
            atunci s-a gasit o aparitie si se noteaza
             */
            if(sir1.equals(sir2.substring(i, i + sir1.length()))){
                aparitie++;
            }
        }


        System.out.println("Numarul de aparitii al sirului \"" + sir1 + "\" este de " + aparitie + " ori, folosind metoda substring");

        //se verifica daca exista subsirul in sirul mare
        if(sir2.indexOf(sir1) == -1){
            System.out.println("Nu exista sirul \"" + sir1 + "\" in sirul " + sir2);
        }

        else{
            aparitie = 0;
            i = 0;

            //cat timp exista o pozitie la care se gaseste sirul 1, atunci mai exista aparitii
            //si se mareste numarul de aparitii
            while(sir2.indexOf(sir1, i) != -1){
                aparitie++;
                i = sir2.indexOf(sir1, i) + 1;
            }

            System.out.println("Numarul de aparitii al sirului \"" + sir1 + "\" este de " + aparitie + " ori, folosind metoda indexOf");
        }
    }
}
