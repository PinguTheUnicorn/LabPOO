import java.util.Vector;

//se declara clasa Person
class Person {
    //date private
    private String name;
    private String address;

    //constructor
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //metoda ce intoarce numele
    public String getName() {
        return name;
    }

    //metoda ce intoarce adresa
    public String getAddress() {
        return address;
    }

    //metoda ce schimba adresa
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + ": " + address;
    }
}

//clasa Student ce e o subclasa a lui Person
class Student extends Person {
    //date private
    private Vector courses;
    private Vector grades;

    //constructor ce se foloseste de constructorul lui super
    public Student(String name, String address) {
        super(name, address);
        courses = new Vector();
        grades = new Vector();
    }

    //metoda auxiliara pentru transformarea cursurilor cu note in string
    private String gradesToString() {
        String result = "";

        int i, n = courses.size(); //se retine numarul de elemente

        //se parcurg elementele
        for(i = 0; i < n; i++) {
            //se adauga cursul
            result += courses.get(i) + " ";
            //apoi nota acestuia
            result += grades.get(i) + "\n";
        }

        //se intoarce rezultatul
        return result;
    }

    public String toString() {
        //se foloseste de metoda lui super
        String result = super.toString();
        result += "\n";
        //la care se adauga cursurile
        result += gradesToString();

        return result;
    }

    //metoda de adaugare a unui curs + nota
    public void addCourseGrade(String course, int grade) {
        //se verifica daca acest curs nu este inca adaugat
        if(!courses.contains(course)) {
            //in caz afirmativ, se adauga cursul
            courses.addElement(course);
            //si nota
            grades.addElement(grade);
        }
    }

    //metoda de afisare a notelor
    public void printGrades() {
        //se afiseaza notele si materia
        //folosindu-se de metoda auxiliara creata anterior
        System.out.println(gradesToString());
    }

    //metoda pentru calcularea mediei
    public double getAverageGrade() {
        //se retine numarul de elemente
        int i, n = grades.size();
        int sum = 0;

        //se parcurge vectorul de note
        for(i = 0; i < n; i++) {
            //se insumeaza fiecare nota
            sum += (int)grades.elementAt(i);
        }

        //la final se intoarce media
        return (double)sum / (double)n;
    }
}

//clasa Teacher, subclasa a lui Persin
class Teacher extends Person {
    //date private
    private Vector<String> courses;

    //constructor ce se foloseste de cel al lui super
    public Teacher(String name, String address) {
        super(name, address);
    }

    //metoda ce conversie ce se foloseeste de metoda lui super
    public String toString() {
        String result = super.toString();
        result += "\nCourses: ";

        int i, n = courses.capacity();

        //se parcurge lista de cursuri
        for(i = 0; i < n; i++) {
            //se adauga in sir fiecare curs
            result += courses.elementAt(i) + " ";
        }

        result += "\n";

        //se intoarce forma dorita
        return result;
    }

    //metoda de adaugare a unui curs
    public boolean addCourse(String course) {
        //se verifica existenta cursului
        if(!courses.contains(course)) {
            //daca nu exista, acesta se adauga
            courses.add(course);
            return true;
        }

        //daca exista deja, se intoarce false
         return false;
    }

    //metoda de stergere a uunui curs
    public boolean removeCourse(String course) {
        //daca exista cursul respectiv
        if(courses.contains(course)) {
            //acesta se sterge
            courses.remove(course);
            return true;
        }

        //in caz contrar, se intoarce false
        return false;
    }
}

class Test4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}
