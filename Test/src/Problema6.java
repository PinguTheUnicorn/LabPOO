/*programul ia toate numerele de la 1 la 20 si verifica daca sunt prime
verificand daca au si alti divizori in afara de 1 si ei insisi*/
public class Problema6 {
    public boolean prim(int n){
        int i;
        if(n == 1) return true; //se verifica daca numarul este 1, caz in care se intoarce adevarat
        for(i = 2; i <= n/2; i++){ //se iau toate numere de la 2 la jumatatea numarului n
            if(n % i == 0) return false; //daca se gaseste un divizor, numarul este prim si se intoarce false
        }

        return true; //daca nu s-a gasit niciun divizor, atunci functia intoarce true
    }

    public static void main(String[] args) {
        int i;
        Problema6 obiect = new Problema6(); //se declara un obiect
        for(i = 1; i <= 20; i++){ //se iau toate numerele de la 1 la 20 si se verifica
            if(obiect.prim(i)){ //folosind metoda prim
                System.out.println("Numarul " + i + " este prim");
            }
            else {
                System.out.println("Numarul " + i + " nu este prim");
            }
            //se afiseaza mesajul corespunzator
        }
    }
}
