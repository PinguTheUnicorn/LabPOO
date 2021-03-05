public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(boolean choice, Channel canal) {
        if(choice)
            canal.subscribe(this);
        else
            canal.unsubscribe(this);
    }

    public void getNotification(String notification) {
        System.out.println(name + " a primit notificarea:\n" + notification);
    }
}
