import java.util.ArrayList;

public class Channel {
    private ArrayList<User> subscribers;
    private String name;

    public Channel(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    protected void subscribe(User user) {
        subscribers.add(user);
    }

    protected void unsubscribe(User user) {
        subscribers.remove(user);
    }

    protected void notify(String notification) {
        for (User user:
             subscribers) {
            user.getNotification(notification);
        }
    }
}
