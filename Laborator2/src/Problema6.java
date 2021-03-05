import java.util.*;
public class Problema6 {
    public static void main(String[] args) {
        Vector v = new Vector();
        Vector<Integer> aparitii = new Vector<>();
        String tip[] = new String[]{"Int", "Double", "Float", "String", "Char", "Boolean"};
        int i, j;

        for(j = 0; j < tip.length; j++){
            aparitii.add(0);
        }

        v.add(7.5f);
        v.add("String");
        v.add(4);
        v.add(true);
        v.add(5);
        v.add("sir");
        v.add(4.555);
        v.add(3.12);
        v.add('c');

        for(i = 0; i < v.size(); i++){
            for(j = 0; j < tip.length; j++){
                //System.out.println(v.get(i).getClass());
                if(v.get(i).getClass().toString().contains(tip[j])){
                    aparitii.set(j, aparitii.get(j) + 1);
                }
            }
        }

        for(j = 0; j < tip.length; j++){
            System.out.println("Tipul " + tip[j] + " apare de " + aparitii.get(j) + " ori");
        }
    }
}
