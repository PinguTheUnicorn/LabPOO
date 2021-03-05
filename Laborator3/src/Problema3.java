class MyArray {
    private int v[];
    private int size;

    public MyArray() {
        this(100);
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}

class MyQueue{
    private MyArray vector; //vectorul pentru stocat valorile
    private static final int infinit = 9500;
    private int first; //indicele primului element
    private int last; //indicele ultimului element
    private int size; //dimensiune

    // Constructor
    MyQueue(){
        vector = new MyArray(infinit); //se declara un vector de dimensiune infinita
        size = 0; //dimensiunea se seteaza pe 0 pentru ca nu avem inca un element
        first = 0; //primul element va fi adaugat pe pozitia 0
        last = -1; //nu exista inca un ultim element, deci pozitia este -1
    }

    public int getSize(){
        return size; //se intoarce dimensiunea actuala
    }

    public void enqueue(int value){
        //se adauga un nou element in vector, de la pozitia urmatoare, aceasta devenind ultima pozitie
        vector.set(++last, value);
        size++; //se mareste dimensiunea cozii
    }

    public int dequeue(){
        if(!isEmpty()){ //daca mai sunt elemente in coada
            size--; //numarul acestora scade
            //se intoarce primul element din coada, iar urmatorul element devine primul
            return vector.get(first++);
        }
        else {
            return infinit; //daca nu mai exista elemente, se intoarce infinit
        }
    }

    public boolean isEmpty(){
        return (getSize() == 0); //se verifica daca dimensiunea este 0
    }

    //afiseaza coada de la primul la ultimul element
    public String toString(){
        String rezultat = "";
        int i;

        //se parcurge fiecare element din vector, de la primul la ultimul din coada
        for(i = first; i <= last; i++){
            rezultat += vector.get(i) + " "; //se adauga la sirul de afisat
        }

        return rezultat;
    }
}

class TestP3 {
    public static void main(String args[]) {
        System.out.println("pula");
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);
    }
}
