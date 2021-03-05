import java.util.Collection;

public class BestPartialScore implements Strategy{
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Student student = null;
        Double partial = 0.0;
        for (Grade grade:
             grades) {
            if (grade.getPartialScore() > partial)
                partial = grade.getPartialScore();
        }

        for (Grade grade:
             grades) {
            if (grade.getPartialScore() == partial)
                student = grade.getStudent();
        }

        return student;
    }
}
