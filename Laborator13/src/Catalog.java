import java.util.ArrayList;

public class Catalog implements Subject{
    private static Catalog catalog = null;
    private ArrayList<Course> cursuri;
    private ArrayList<Observer> observers;

    private Catalog() {
        cursuri = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public Course getCourse(String name) {
        for (Course course:
             cursuri) {
            if (course.getNume().equals(name))
                return course;
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return cursuri;
    }

    public void addCourse(Course course) {
        cursuri.add(course);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeCourse(Course course) {
        cursuri.remove(course);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer parent:
             observers) {
            if (grade.getStudent().isParent(parent))
                parent.update(new Notification("Notele copilului sunt " + grade));
        }
    }

    public static Catalog getInstance() {
        if(catalog == null)
            catalog = new Catalog();
        return catalog;
    }

    public String toString() {
        String rezultat = "";

        for (Course course:
             cursuri) {
            rezultat += course;
        }
        return rezultat;
    }


}
