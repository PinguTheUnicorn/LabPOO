import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Problema1 {
    public TreeSet<String> printWords(String fileName) throws IOException{
        TreeSet<String> words = new TreeSet<>();

        try {
            RandomAccessFile fisier = new RandomAccessFile(fileName, "r");
            while(fisier.getFilePointer() < fisier.length()) {
                String[] linie = fisier.readLine().split("[ ,.{}\";():]");
                int i;
                for(i = 0; i < linie.length; i++) {
                    words.add(linie[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public TreeSet<String> printWordsComparator(TreeSet<String> input) {
        TreeSet<String> words = new TreeSet<String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int value = ((String) o1).compareTo((String) o2);
                if(value > 0)
                    return -1;
                if(value < 0)
                    return 1;
                return 0;
            }
        });
        words.addAll(input);

        return words;
    }

    public static void main(String[] args) {
        Problema1 test = new Problema1();
        String s1 = "G:\\proiecte\\poo\\Laboratorul7\\Problema1\\src\\test01.txt";
        try {
            TreeSet<String> set1 = test.printWords(s1);
            System.out.println(set1 + " !!!!!!!! set1\n");

            TreeSet<String> set2 = test.printWordsComparator(set1);
            System.out.println(set2 + " !!!!!!!! set2\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
