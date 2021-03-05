import java.util.*;

public class Problema4 {
    public Vector<Integer> reuniune(Vector<Integer> v1, Vector<Integer> v2){
        Vector<Integer> v3 = new Vector<>();
        int i = 0;

        while(i < v1.size()) {
            v3.add(v1.get(i));
            i++;
        }

        i = 0;

        boolean ok;

        while(i < v2.size()){
            ok = v3.contains(v2.get(i));
            if(!ok)
                v3.add(v2.get(i));
            i++;
        }

        return v3;
    }

    public Vector<Integer> intersectie(Vector<Integer> v1, Vector<Integer> v2){
        Vector<Integer> v3 = new Vector<>();
        int i = 0;
        boolean ok1, ok2, ok3;

        while(i < v1.size() && i < v2.size()){
            ok1 = v1.contains(v2.get(i));
            ok3 = v3.contains(v2.get(i));

            if(ok1 && !ok3){
                v3.add(v2.get(i));
            }

            ok2 = v2.contains(v1.get(i));
            ok3 = v3.contains(v1.get(i));

            if(ok2 && !ok3){
                v3.add(v1.get(i));
            }

            i++;
        }

        while(i < v1.size()){
            ok2 = v2.contains(v1.get(i));
            ok3 = v3.contains(v1.get(i));
            if(ok2 && !ok3){
                v3.add(v1.get(i));
            }

            i++;
        }

        while(i < v2.size()){
            ok1 = v1.contains(v2.get(i));
            ok3 = v3.contains(v2.get(i));
            if(ok1 && !ok3){
                v3.add(v2.get(i));
            }

            i++;
        }

        return v3;
    }

    public Vector<Integer> diferenta(Vector<Integer> v1, Vector<Integer> v2){
        Vector<Integer> v3 = new Vector<>();
        int i = 0;
        boolean ok;

        while(i < v1.size()){
            ok = v2.contains(v1.get(i));
            if(!ok){
                v3.add(v1.get(i));
            }

            i++;
        }

        return v3;
    }

    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>();
        Vector<Integer> v3;

        int i;
        Problema4 obiect = new Problema4();

         for(i = 0; i < 10; i++){
             v1.add(i);
             v2.add(i);
             v2.add(i + 10);
         }

         System.out.println(v1 + " + " + v2);

         v3 = obiect.reuniune(v1, v2);
         System.out.println("Reuniune: " + v3);

         v3 = obiect.intersectie(v1, v2);
         System.out.println("Intersectie: " + v3);

         v3 = obiect.diferenta(v1, v2);
         System.out.println("Diferenta 1: " + v3);

         v3 = obiect.diferenta(v2, v1);
         System.out.println("Diferenta 2: " + v3);
    }
}
