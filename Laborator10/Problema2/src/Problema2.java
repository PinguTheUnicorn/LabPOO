import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class Problema2 extends JFrame implements ActionListener{
    private JRadioButton b1;
    private JRadioButton b2;
    private JRadioButton b3;
    private JRadioButton b4;
    private ButtonGroup group;
    private JTextField f;
    private JButton button;

    public Problema2(String titlu, Vector<String> file) {
        super(titlu);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.orange);
        setLayout(new FlowLayout());

        button = new JButton("Testare");
        button.addActionListener(this);
        button.setEnabled(false);
        add(button);

        f = new JTextField(file.get(0));
        f.setEditable(false);
        add(f);

        b1 = new JRadioButton(file.get(1));
        b1.addActionListener(this);
        add(b1);

        b2 = new JRadioButton(file.get(2));
        b2.addActionListener(this);
        add(b2);

        b3 = new JRadioButton(file.get(3));
        b3.addActionListener(this);
        add(b3);

        b4 = new JRadioButton(file.get(4));
        b4.addActionListener(this);
        add(b4);

        group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);

        setVisible(true);
        //pack();
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            File f = new File("G:\\proiecte\\poo\\Laborator10\\Problema2\\src\\input.txt");
            Vector<String> files = new Vector();
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                files.add(s.nextLine());
            }

            Problema2 p2 = new Problema2("Probelam2", files);
        } catch (FileNotFoundException e) {
            System.out.println("Nu exista fisierul");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JRadioButton) {
            button.setEnabled(true);
        } else {
            for(Enumeration<AbstractButton> buttons =
            group.getElements(); buttons.hasMoreElements();) {
                JRadioButton b = (JRadioButton) buttons.nextElement();

                if(b.isSelected()) {
                    if(b.getText() == b1.getText()) {
                        b.setForeground(Color.green);
                    } else {
                        b.setForeground(Color.red);
                    }
                }
            }
        }
    }
}
