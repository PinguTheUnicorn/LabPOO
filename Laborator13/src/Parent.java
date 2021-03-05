import java.util.ArrayList;

public class Parent extends User implements Observer{
    private ArrayList<Notification> notifications;
    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        notifications = new ArrayList<>();
    }


    @Override
    public void update(Notification notification) {
        System.out.println("Am luat in cunostiinta de cauza nota copilului" +
                " meu\n" + this + "\n");
        notifications.add(notification);
    }
}
