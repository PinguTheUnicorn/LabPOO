class Punct {
    private int x;
    private int y;

    Punct(){
        x = 0;
        y = 0;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public double distance(int x, int y){
        return Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2));
    }

    public double distance(Punct p1){
        return distance(p1.x, p1.y);
    }
}

class TestP5{
    public static void main(String[] args) {
        Punct a = new Punct();
        Punct b = new Punct();
        a.setX(1);
        a.setY(2);
        b.setX(-1);
        b.setY(3);

        System.out.println(a.distance(b));
        System.out.println(a + " " + b);
    }
}
