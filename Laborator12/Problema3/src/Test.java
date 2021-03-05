public class Test {
    public static void main(String[] args) {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");

        Channel c1 = new Channel("c1");
        Channel c2 = new Channel("c2");
        Channel c3 = new Channel("c3");

        u1.update(true, c1);
        u1.update(true, c2);
        u1.update(true, c3);

        u2.update(true, c3);
        u2.update(true, c1);

        u3.update(true, c1);
        u3.update(true, c2);

        c1.notify("Notificare din partea c1\n");
        u1.update(false, c1);

        c1.notify("Alta notificare din partea c1\n");
        c3.notify("Imi place sa mananc a postat un clip nou c3\n");

        u2.update(false, c3);
        c3.notify("Imi place sa mananc transmite un flux live c3\n");

        c2.notify("De ce nu si c2?\n");
    }
}
