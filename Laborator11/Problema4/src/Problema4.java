import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class Problema4 extends JFrame {
    private JTree arbore;
    private JTable tabel;
    private JScrollPane stanga;
    private JPanel dreapta;
    private TreePath pathToNode;
    private String[] colNames = {"File Name", "Dimension", "Last" +
            "Modified", "Type"};
    private Object[][] data =  { {"", "", "", ""}};

    public Problema4(String path) {
        super("Problema4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.orange);
        setLayout(new GridLayout(1, 2));

        File rootDirectory = new File(path);
        DefaultMutableTreeNode root =
                new DefaultMutableTreeNode(rootDirectory.getName());
        createTree(root, rootDirectory);

        arbore = new JTree(root);
        arbore.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        arbore.getLastSelectedPathComponent();

                if(node.children().hasMoreElements()) {
                    TreeNode[] tp = node.getPath();
                    String path = "G:";

                    for (int i = 0; i < tp.length; i++) {
                        path += "\\" + tp[i];
                    }

                    File file = new File(path);
                    String[] children = file.list(); //nu imi gaseste fisierele, chiar daca exista
/*                    String[] files = file.list();
                    File[] fileDir = new File[files.length];
                    for(int i = 0; i < files.length; i++) {
                        fileDir[i] = new File(file.getPath() +
                                "\\" + files[i]);
                    }
                    System.out.println(fileDir);

                    for(int i = 0; i < fileDir.length; i++) {
                        data[i][0] = fileDir[i].getName();
                        data[i][1] = fileDir[i].getTotalSpace();
                        Path aux = Path.of(fileDir[i].toURI());

                        try {
                            BasicFileAttributes attr = Files.readAttributes(aux, BasicFileAttributes.class);
                            data[i][2] = attr.lastModifiedTime();
                        } catch (IOException ioException) {
                            System.out.println("Ma pis pe ele de exceptii");
                        }
                        if(fileDir[i].isFile()) {
                            data[i][3] = "File";
                        } else  {
                            data[i][3] = "Directory";
                        }
                    }

                    tabel = new JTable(data, colNames);*/
                }
            }
        });
        stanga = new JScrollPane(arbore);
        add(stanga);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        tabel = new JTable(data, colNames);
        JTableHeader header = tabel.getTableHeader();
        tablePanel.add(header, BorderLayout.NORTH);
        tablePanel.add(tabel, BorderLayout.CENTER);
        dreapta = new JPanel();
        dreapta.add(tablePanel);
        add(dreapta);

        setVisible(true);
        pack();
    }

    private void createTree(DefaultMutableTreeNode root,
                                              File directory) {
        File[] children = directory.listFiles();

        if(children != null) {
            for(File child : children) {
                if(child.isFile())
                    root.add(new DefaultMutableTreeNode(child.getName()));
                else {
                    DefaultMutableTreeNode kidRoot =
                            new DefaultMutableTreeNode(child.getName());
                    createTree(kidRoot, child);
                    root.add(kidRoot);
                }
            }
        }
    }

    public static void main(String[] args) {
        Problema4 p4 = new Problema4("G:\\proiecte\\poo");
    }
}
