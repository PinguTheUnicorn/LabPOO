class Graph{
    private int[][] matrice;
    private static final int Infinit = 9500;
    int n;

    Graph(int n){
        this.n = n;
        matrice = new int[n + 1][n + 1];
        int i, j;

        for(i = 1; i < matrice.length; i++){
            for(j = 1; j < matrice.length; j++){
                if(i == j){
                    matrice[i][j] = 0;
                }

                else{
                    matrice[i][j] = Infinit;
                }
            }
        }
    }

    public int getSize(){
        return n;
    }

    public void addArc(int v, int w, int cost){
        matrice[v][w] = cost;
    }

    public boolean isArc(int v, int w){
        return (matrice[v][w] != Infinit);
    }

    public String toString(){
        String rezultat = "  ";
        int i, j;

        for(i = 1; i <= n; i++){
            rezultat += "  " + i + "   ";
        }
        rezultat += "\n";

        for(i = 1; i <= n; i++){
            rezultat += i + " ";
            for(j = 1; j <= n; j++){
                if(isArc(i, j)) {
                    rezultat += "  " + matrice[i][j] + "   ";
                }
                else {
                    rezultat += "Infinit ";
                }
            }
            rezultat += "\n";
        }

        return rezultat;
    }

    public int[][] floydWarshall() {
        int result[][];
        result = new int[n+1][n+1];
        int k, i, j;
        for(i = 1; i <= n; i++) {
            for(j = 1; j <= n; j++) {
                if(i == j) {
                    result[i][j] = 0;
                } else if(isArc(i, j)) {
                    result[i][j] = matrice[i][j];
                } else {
                    result[i][j] = Infinit;
                }
            }
        }
        for(k = 1; k <= n; k++) {
            for(i = 1; i <= n; i++) {
                for(j = 1; j <= n; j++) {
                    int dist;
                    dist = result[i][k] + result[k][j];
                    if(result[i][j] > dist) {
                        result[i][j] = dist;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addArc(1, 3, 2);
        g.addArc(1, 2, 3);
        g.addArc(2, 4, 6);
        g.addArc(2, 3, 2);
        System.out.println(g);
        System.out.println("Floyd-Warshall");
        int [][] my_matrix = g.floydWarshall();
        System.out.println("distanta minima dintre nodurile 1 si 4 este "+ my_matrix[1][4]); // rezultat - 9
    }
}