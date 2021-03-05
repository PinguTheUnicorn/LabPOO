import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Problema1 extends JFrame{
    private JList lista;

    public Problema1(Vector<Book> input) {
        super("Problema1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setBackground(Color.orange);
        setLayout(new FlowLayout());

        lista = new JList(input);
        add(new JScrollPane(lista));
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        int i;
        Vector<Book> input = new Vector();
        for(i = 0; i < 15; i++) {
            input.add(new Book("Carte" + (i + 1),
                    "Autor" + (i + 1), ""));
        }

        Problema1 p1 = new Problema1(input);
    }
}
