import java.util.*;

class Pair<K, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;
    public Pair(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }
    public K getKey() {
        return key;
    }
    public V1 getValue1() {
        return value1;
    }
    public V2 getValue2() {
        return value2;
    }
}

public class ScoreVisitor implements Visitor {
    private HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores;
    private HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores;
    public ScoreVisitor(HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores, HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores){
        this.examScores=examScores;
        this.partialScores=partialScores;
    }

    public void visit(Assistant assistant) {
        ArrayList<Pair<Student, String, Double>> note =
                partialScores.get(assistant);
        Catalog catalog = Catalog.getInstance();

        for (Pair<Student, String, Double> pair:
             note) {
            Course course = catalog.getCourse(pair.getValue1());

            boolean exista = false;
            for (Grade grade:
                    course.getGrades()) {
                if (grade.getStudent() == pair.getKey()) {
                    exista = true;
                    grade.setPartialScore(pair.getValue2());
                }
            }

            if (!exista)
                course.addGrade(new Grade(pair.getValue1(), pair.getKey(),
                        pair.getValue2(), 0.0));
        }
    }

    public void visit(Teacher teacher) {
        ArrayList<Pair<Student, String, Double>> note = examScores.get(teacher);
        Catalog catalog = Catalog.getInstance();

        for (Pair<Student, String, Double> pair:
             note) {
            Course course = catalog.getCourse(pair.getValue1());

            boolean exista = false;
            for (Grade grade:
                 course.getGrades()) {
                if (grade.getStudent() == pair.getKey()) {
                    grade.setExamScore(pair.getValue2());
                    exista = true;
                }
            }

            if (!exista)
                course.addGrade(new Grade(pair.getValue1(), pair.getKey(), 0.0, pair.getValue2()));
        }
    }
}