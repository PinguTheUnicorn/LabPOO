//programul ia toate numerele pana gaseste n numere pare si verifica ipoteza lui Goldbach
public class Prolema7 {
    public static boolean par(int numar){ //metoda pentru a verifica daca un numar dat este par
        if(numar % 2 == 0) return true;
        else return false;
    }

    public static void goldbach(int numar){
        int i;
        //se declara un obiect pentru a folosi metoda de determinare a numerelor prime de la problema 6
        Problema6 obiect = new Problema6();
        //se iau numerele pana la jumatatea lui "numar" si se verifica daca ele si diferenta pana la "numar" sunt prima
        for(i = 1; i <= numar / 2; i++){
            if(obiect.prim(i) && obiect.prim(numar - i)){
                //in caz afirmativ, se afiseaza descompunerea
                System.out.println(numar + " = " + i + " + " + (numar-i));
            }
        }
    }

    public static void main(String[] args) {
        int i = 2, n = 10, par = 0;
        //cat timp nu s-au gasit n numere pare, se cauta
        while(par != n){
            if(par(i)){ //daca numarul gasit este par, se aplica ipoteza lui Goldbach
                par++; //creste numarul de numere pare gasite
                System.out.println("Pentru numarul " + i + " avem urmatoarele descompuneri:");
                goldbach(i);
            }

            i++; //se trece la urmatorul numar prin incrementare
        }
    }
}
