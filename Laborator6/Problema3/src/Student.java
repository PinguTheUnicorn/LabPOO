import java.util.Collections;
import java.util.Vector;

interface Persoana extends Comparable {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

public class Student implements Persoana {
    private String nume;
    private Vector<Double> medie = new Vector<Double>();

    public double calculMedieGenerala() {
        int i, n = medie.size();
        double total = 0;

        for(i = 0; i < n; i++) {
            total += medie.get(i);
        }

        return total/n;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void addMedie(double medie) {
        this.medie.addElement(medie);
    }

    public int compareTo(Object o) {
        Student s2 = (Student) o;

        if(nume.compareTo(s2.getNume()) != 0) {
            return (nume.compareTo(s2.getNume()));
        } else {
            double m1, m2;
            m1 = calculMedieGenerala();
            m2 = s2.calculMedieGenerala();

            if(m1 > m2) {
                return -1;
            }
            if(m1 < m2) {
                return 1;
            }

            return 0;
        }
    }

    public String toString() {
        String s = "";
        int i, n = medie.size();

        s += nume + ":";

        for(i = 0; i < n ; i++) {
            s += " " + medie.get(i);
        }

        return s;
    }

    public static void main(String[] args) {
        Vector<Persoana> v = new Vector<Persoana>(5);
        Persoana p1, p2, p3, p4, p5;

        p1 = new Student();
        p1.setNume("Andrei");
        p1.addMedie(10);
        p1.addMedie(5);
        p1.addMedie(2);

        v.addElement(p1);

        p2 = new Student();
        p2.setNume("Mimi");
        p2.addMedie(5);
        p2.addMedie(5);
        p2.addMedie(7);

        v.addElement(p2);

        p3 = new Student();
        p3.setNume("Ana");
        p3.addMedie(9);
        p3.addMedie(7);
        p3.addMedie(8);

        v.addElement(p3);

        p4 = new Student();
        p4.setNume("Andrei");
        p4.addMedie(5);
        p4.addMedie(5);
        p4.addMedie(7);

        v.addElement(p4);

        p5 = new Student();
        p5.setNume("Ana");
        p5.addMedie(10);
        p5.addMedie(10);
        p5.addMedie(9);

        v.addElement(p5);

        Collections.sort(v);
        System.out.println(v);
    }
}
