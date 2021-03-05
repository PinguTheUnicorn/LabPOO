import java.util.*;
class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
    }

    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array {
    //se rescriu metodele pentru a se mula nevoilor clasei

    //metoda ce adauga un element, punandu-l intr-o pozitie corespunzatoare
    public void addElement(Integer x) {
        super.addElement(x); //se adauga element la finalul array-ului
        sort(); //se sorteaza elementele pentru a se pastra forma dorita
    }

    //metoda ce adauga un element la o pozitie, daca aceasta este corespunzatoare
    public void addElement(Integer x, int poz) {
        if(poz == 0) { //daca elementul se vrea pus pe prima pozitie
            //se verifica daca va fi mai mic decat elementul actual, ce va fi mutat in dreapta
            if(x <= get(poz)) {
                super.addElement(x, poz); //in caz afirmativ, se adauga elementul
            }
        } else {
            /*daca elementul se doreste adaugat oriunde altundeva
            se verifica daca este mai mic decat elementul inlocuit
            si mai mare decat elementul din stanga*/
            if(get(poz - 1) <= x && x <= get(poz)) {
                super.addElement(x, poz); //in caz afirmativ, se adauga
            }
        }
    }
}

class MyStack {
    private Array elemente;

    //constructorul clasei, initializeaza elementul stiva
    MyStack() {
        elemente = new Array();
    }

    //metoda de adaugare element pe stiva
    public void push(Integer x) {
        //se adauga elementul la finalul vectorului, folosindu-se metoda lui super
        elemente.addElement(x);
    }

    //metoda de eliminare a elementului din stiva
    public Integer pop() {
        //se elimina ultimul element din vector, folosindu-se metodele lui super
        return elemente.remove(elemente.getSize() - 1);
    }
}

class Main {
    public static void main(String[] args) {
        SortedArray a1 = new SortedArray();
        MyStack s1 = new MyStack();

        a1.addElement(1);
        a1.addElement(2);
        a1.addElement(3);
        System.out.println(a1);
        a1.addElement(4, 2);
        a1.addElement(0, 0);
        System.out.println(a1);

        s1.push(13);
        s1.push(14);
        s1.push(15);
        System.out.println(s1.pop() + " " + s1.pop() + " " + s1.pop());
        s1.push(11);
        System.out.println(s1.pop());
    }
}
