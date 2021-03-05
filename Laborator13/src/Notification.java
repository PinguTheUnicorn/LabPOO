public class Notification {
    private String mesaj;

    public Notification(String mesaj) {
        this.mesaj = mesaj;
    }

    @Override
    public String toString() {
        return "Aveti urmatoarea notificare: " + mesaj;
    }
}
