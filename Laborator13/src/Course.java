import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Course {
    private final String nume;
    private Teacher titular;
    private ArrayList<Assistant> assitants;
    private ArrayList<Student> students;
    private ArrayList<Grade> grades;
    private ArrayList<Observer> parents;
    private Strategy strategy;

    private Course(CourseBuilder builder){
        this.nume = builder.nume;
        this.titular = builder.titular;
        this.assitants = builder.assistants;
        this.students = builder.students;
        this.grades = builder.grades;
        this.strategy = builder.strategy;
    }

    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public String getNume() {
        return nume;
    }

    public Teacher getTitular() {
        return titular;
    }

    public ArrayList<Assistant> getAssitants() {
        return assitants;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String toString() {
        return nume + " " + titular + ":\n" + assitants + "\n" + students +
                "\n" + grades;
    }

    public static class CourseBuilder {
        private final String nume;
        private Teacher titular;
        private ArrayList<Assistant> assistants;
        private ArrayList<Student> students;
        private ArrayList<Grade> grades;
        private Strategy strategy;

        public CourseBuilder(String nume) {
            this.nume = nume;
        }

        public CourseBuilder teacher(Teacher titular) {
            this.titular = titular;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            if (assistants == null)
                assistants = new ArrayList<>();
            assistants.add(assistant);
            return this;
        }

        public CourseBuilder student(Student student) {
            if (students == null)
                students = new ArrayList<>();
            students.add(student);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            if(grades == null)
                grades = new ArrayList<>();
            grades.add(grade);
            grades.sort(new Comparator<Grade>() {
                @Override
                public int compare(Grade o1, Grade o2) {
                    return (int)(o1.getTotal() - o2.getTotal());
                }
            });

            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

}

