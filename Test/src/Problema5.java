public class Problema5 {
    public int calculputere(int baza, int putere){
        if(putere == 0) return 1;
        if(putere == 1) return baza;
        return baza * calculputere(baza, putere - 1);
    }

    public void rezultat(int baza, int putere){
        System.out.println(calculputere(baza, putere));
        System.out.println(Math.pow(baza, putere));
    }

    public static void main(String[] args) {
        Problema5 testare = new Problema5();
        testare.rezultat(5, 3);
    }
}
