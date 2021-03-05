import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

class Problema1 extends JFrame implements ActionListener{
     private JButton button;
     private JTextField disc;
     private JTextField path;
     private JTextField file;
     private JTextField output;

    public Problema1 (String text){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.orange);
        setLayout(new FlowLayout());
        button = new JButton ("Rezultat");
        button.addActionListener(this);
        add(button);

        disc = new JTextField(10);
        disc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path.requestFocusInWindow();
            }
        });
        add(disc);

        path = new JTextField(10);
        path.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file.requestFocusInWindow();
            }
        });
        add(path);

        file = new JTextField(10);
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disc.requestFocusInWindow();
            }
        });
        add(file);

        output = new JTextField(10);
        output.setEditable(false);
        add(output);
        setVisible(true);
        pack();
    }

    public static void main (String args[]){
        Problema1 p1 = new Problema1 ("Problema1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rez = disc.getText();
        rez += path.getText() + file.getText();
        output.setText(rez);
    }
}
