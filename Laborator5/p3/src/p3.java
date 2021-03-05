import java.util.*;

class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ\n");
    }
}

class Problema3 {
    Vector v;
    Scanner read;

    Problema3() {
        v = new Vector();
        read = new Scanner(System.in);
    }

    void myRead() throws NumarNegativ {
        int input;

        do {
            input = read.nextInt();
            if(input < 0) {
                throw new NumarNegativ();
            }
            else {
                v.add(input);
            }
        } while (input > 0);
    }

    public static void main(String[] args) {
        Problema3 rezolvare = new Problema3();
        try {
            rezolvare.myRead();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            int max = (int) Collections.max(rezolvare.v);
            System.out.println(max);
        }
    }
}
