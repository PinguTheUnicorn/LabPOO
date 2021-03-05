import java.util.Collection;

public class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Student student = null;
        Double exam = 0.0;
        for (Grade grade:
             grades) {
            if (grade.getExamScore() > exam)
                exam = grade.getExamScore();
        }

        for (Grade grade:
             grades) {
            if (grade.getExamScore() == exam)
                student = grade.getStudent();
        }

        return student;
    }
}
