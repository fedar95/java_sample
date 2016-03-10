import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main extends JFrame {

    // Creates a dialog, reads list of goods from file and gets info. You can add new information, too
    JFileChooser f = new JFileChooser();
    final int FRAME_X = 500, FRAME_Y = 350;
    final int TEXT_FIELD_WIDTH = 5;
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JTextArea list = new JTextArea(10, 20);
    JButton find = new JButton("Find info");
    JButton addGood = new JButton("Add");
    JPanel listPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JTextArea results = new JTextArea(5, 20);
    JTextField inputText = new JTextField(20);
    JPanel inputPanel = new JPanel();
    JLabel inputLabel = new JLabel("Type the name: ");
    JScrollPane scroll = new JScrollPane();
    MyDialog addDialog = new MyDialog();
    MyContainer cont = new MyContainer();

    public Main() {
        setPreferredSize(new Dimension(FRAME_X, FRAME_Y));
        JPanel content = (JPanel) this.getContentPane();
        content.setLayout(new GridLayout(0, 2));
        scroll.getViewport().add(list);
        listPanel.setLayout(new BorderLayout());
        listPanel.add(addGood, BorderLayout.SOUTH);
        listPanel.add(scroll, BorderLayout.NORTH);
        content.add(listPanel);
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);
        resultPanel.setLayout(new GridLayout(2, 2));
        resultPanel.add(find);
        resultPanel.add(inputPanel);
        resultPanel.add(results);
        content.add(resultPanel);
        fileMenu.add(openFile);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        openFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = f.showOpenDialog(null);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = f.getSelectedFile();
                    try {
                        Scanner sc = new Scanner(file);
                        Goods g;
                        while (sc.hasNext()) {
                            g = new Goods(sc.next(), sc.next(), sc.nextInt());
                            cont.add(g);
                        }
                        cont.sort();
                        list.setText(cont.show());
                    } catch (FileNotFoundException e1) {
                        System.out.println("OOPS!");
                    }
                }

            }

        });
        find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String goodsName = inputText.getText();
                TreeSet<String> countries = cont.getCountries(goodsName);
                Iterator<String> it = countries.iterator();
                StringBuilder str = new StringBuilder("Countries:\n\n");
                while (it.hasNext()) {
                    str.append(it.next());
                    str.append("\n");
                }
                str.append("\nTotal value: ");
                str.append(cont.getTotalValue(goodsName));
                results.setText(str.toString());
            }

        });
        addDialog.OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addDialog.newGood = new Goods(addDialog.nameText.getText(),
                        addDialog.countryText.getText(), Integer
                        .parseInt(addDialog.numberText.getText()));
                addDialog.setVisible(false);
                cont.add(addDialog.newGood);
                addDialog.newGood = null;
                cont.sort();
                inputText.setText(null);
                results.setText(null);
                list.setText(cont.show());
            }
        });
        addGood.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addDialog.setVisible(true);

            }

        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Goods info");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new Main();
    }

}
