class Numar {
    int nr;

    public int suma(int a){
        return nr + a;
    }

    public int suma(int a, int b){
        return suma(a) + b;
    }

    public int suma(int a, int b, int c){
        return suma(a, b) + c;
    }

    public int suma(int a, int b, int c, int d){
        return suma(a, b, c) + d;
    }

    public static void main(String[] args) {
        Numar da = new Numar();

        da.nr = 4;

        System.out.println(da.suma(4, 5, 6, 10));
    }
}
