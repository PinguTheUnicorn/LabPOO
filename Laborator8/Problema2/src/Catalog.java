import java.util.*;

public class Catalog extends TreeSet<Catalog.Student> {
    class Student implements Comparable<Student> {
        public String name;
        public double media;
        public int clazz;

        public Student(String name, double medie, int clazz) {
            this.name = name;
            this.media = medie;
            this.clazz = clazz;
        }

        public int compareTo(Student o) {
            if(media < o.media) {
                return -1;
            } else if(media > o.media) {
                return 1;
            }

            return name.compareTo(o.name);
        }

        public String toString() {
            return name + " " + clazz
                    + ": " + media;
        }
    }

    public Catalog() {
        super();
    }

    public Catalog(Comparator<? super Student> comparator) {
        super(comparator);
    }

    public void addStudent(String name, double medie, int clazz) {
        add(new Student(name, medie, clazz));
    }

    public Student getStudent(String name) {
        for (Student s: this) {
            if(s.name == name) {
                return s;
            }
        }

        return null;
    }

    public void removeStudent(String name) {
        removeIf(student -> student.name == name);
    }

    public Catalog byClass(int clazz) {
        Catalog c = new Catalog(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });

        for (Student s: this) {
            if(s.clazz == clazz) {
                c.addStudent(s.name, s.media, s.clazz);
            }
        }

        return c;
    }
}
