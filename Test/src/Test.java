class C{
    public int c = 0;
}

class Test {
    public static void main(String[] args) {
        int x = 0;
        C c = new C();
        f(x, c);
        System.out.println(x + " " + c.c);
    }

    public static void f(int x, C c) {
        x = 10;
        c = new C();
        c.c = 10;
    }
}