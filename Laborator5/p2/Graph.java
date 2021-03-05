public class Graph extends MyList {
    //un array pentru dfs in care se retin elementele vizitate
    private int[] vizitat;

    //constructor ce se foloseste de clasa parinte
    public Graph(int n) {
        super();
        vizitat = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            super.add(new MyList());
        }
    }

    //metoda de add
    public void add(int x, int y) {
        MyList list = (MyList) get(x);
        list.add(y);
    }

    //metoda dfs creata conform algoritmului dat
    public void dfs(int start) {
        System.out.print(start + " ");
        MyList list = (MyList) get(start);
        vizitat[start] = 1;

        if(list != null) {
            for(int i = 0; i < list.size(); i++) {
                int nod = (int) list.get(i);
                if(vizitat[nod] == 0) {
                    dfs(nod);
                }
            }
        }
    }

    //metoda toString ce creaza forma string dupa cum a fost adt in exercitiu
    public String toString() {
        int i;
        String result = "";

        //se ia fiecare nod si se adauga numarul lui in String
        for(i = 1; i < size(); i++) {
            MyList list = (MyList) get(i);
            result += i + ": ";
            //se adauga nodurile adiacente
            result += list;
            //se introfuce newline pentru a se afisa fieccar nod pe cate o linie
            result += '\n';
        }

        return result;
    }
}
