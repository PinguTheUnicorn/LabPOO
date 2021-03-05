import java.io.*;
import java.util.*;

public class Problema5 {
    public List withHashMap(String path) {
        HashMap map = new HashMap();
        File root = new File(path);
        File[] files = root.listFiles();
        int i;

        for(i = 0; i < files.length; i++) {
            if(files[i].isFile()) {
                map.put(files[i].getName(), files[i].length());
            }
        }

        List array = new ArrayList(map.entrySet());

        //implementare pentru sortare descrescatoare
        Collections.sort(array, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry element1 = (Map.Entry) o1;
                String name1 = (String) element1.getKey();
                long size1 = (long) element1.getValue();

                Map.Entry element2 = (Map.Entry) o2;
                String name2 = (String) element2.getKey();
                long size2 = (long) element2.getValue();

                int value = name1.compareTo(name2);
                if(value != 0) {
                    return value * -1;
                } else {
                    if(size1 > size2) {
                        return -1;
                    } else if(size1 < size2){
                        return 1;
                    }
                }
                return 0;
            }
        });

        return array;
    }

    public List withTreeMap(String path) {
        TreeMap map = new TreeMap();

        File root = new File(path);
        File[] files = root.listFiles();

        int i;

        for(i = 0; i < files.length; i++) {
            if(files[i].isFile()) {
                map.put(files[i].getName(), files[i].length());
            }
        }

        List array = new ArrayList(map.entrySet());

        //implementare pentru sortare crescatoare
        Collections.sort(array, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry element1 = (Map.Entry) o1;
                String name1 = (String) element1.getKey();
                long size1 = (long) element1.getValue();

                Map.Entry element2 = (Map.Entry) o2;
                String name2 = (String) element2.getKey();
                long size2 = (long) element2.getValue();

                int value = name1.compareTo(name2);
                if(value != 0) {
                    return value;
                } else {
                    if(size1 > size2) {
                        return 1;
                    } else if(size1 < size2){
                        return -1;
                    }
                }
                return 0;
            }
        });

        return array;
    }

    public static void main(String[] args) {
        Problema5 test = new Problema5();
        String path; //testat pentru diferite cai
        System.out.println("sortare descrescatoare\n" + test.withHashMap(
                path));
        System.out.println("sortare crescatoare\n" + test.withTreeMap(
                path));
    }
}
