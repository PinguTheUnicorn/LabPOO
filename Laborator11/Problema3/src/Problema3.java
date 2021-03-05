import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Problema3 extends JFrame implements ListSelectionListener {
    private JList lista;
    DefaultListModel model;
    private JTextField autor;
    private JTextField titlu;
    private JLabel labelAutor;
    private JLabel labelTitlu;
    private JPanel output;
    private JButton delete;

    public Problema3(Vector<Book> input) {
        super("Problema3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.orange);
        setLayout(new FlowLayout());

        model = new DefaultListModel();
        for(int i = 0; i < input.size(); i++) {
            model.addElement(input.get(i));
        }

        lista = new JList(model);
        lista.addListSelectionListener(this);
        add(new JScrollPane(lista));

        output = new JPanel();
        output.setLayout(new GridLayout(2, 2));
        output.setBackground(Color.blue);

        labelAutor = new JLabel("Autor");
        labelAutor.setForeground(Color.WHITE);
        output.add(labelAutor);
        labelTitlu = new JLabel("Titlu");
        labelTitlu.setForeground(Color.white);
        output.add(labelTitlu);

        autor = new JTextField(10);
        output.add(autor);
        titlu = new JTextField(10);
        output.add(titlu);
        add(output);

        delete = new JButton("Sterge");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = lista.getSelectedIndex();
                model.remove(i);
                titlu.setText("");
                autor.setText("");
            }
        });
        add(delete);

        setVisible(true);
        pack();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(lista.isSelectionEmpty())
            return;

        JList lista = (JList)e.getSource();
        int i = lista.getSelectedIndex();
        Book carte = (Book) model.get(i);
        autor.setText(carte.getAuthor());
        titlu.setText(carte.getName());
    }

    public static void main(String[] args) {
        int i;
        Vector<Book> input = new Vector();
        for(i = 0; i < 15; i++) {
            input.add(new Book("Carte" + (i + 1),
                    "Autor" + (i + 1), ""));
        }

        Problema3 p1 = new Problema3(input);
    }
}
