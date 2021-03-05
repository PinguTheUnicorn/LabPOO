public class Problema8 {
    public static void main(String[] args) {
        double v[] = new double[5]; //se declara un vector de double cu 5 elemente
        int i;
        //este parcurs element cu element si sunt puse valori random folosind metoda random din clasa Math
        for(i = 0; i < v.length; i++){
            v[i] = (double) Math.random();
        }
        //se afiseaza vectorul sub forma de sir
        //folosindu-se metoda toString ce converteste din vector in String
        System.out.println(java.util.Arrays.toString(v));

        double numar = v[1]; //se retine elementul de cautat, ales cel de pe pozitia a doua

        java.util.Arrays.sort(v);//vectorul este sortat
        System.out.println(java.util.Arrays.toString(v));//apoi afisat

        //se foloseste cautarea binara pentru a gasi numarul
        int idx = java.util.Arrays.binarySearch(v, numar);
        if(idx < 0) {//daca rezultatul este negativ, inseamna ca nu a fost gasit
            System.out.println("Numarul nu a fost gasit");
        }
        //altfel, se afiseaza pozitia actuala
        else {
            System.out.println("Numarul a fost gasit la pozitia " + (idx + 1));
        }


    }
}
