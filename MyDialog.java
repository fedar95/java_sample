import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {

    final int FRAME_X = 300, FRAME_Y = 250;
    JPanel dialogPanel = new JPanel();
    JPanel namePanel = new JPanel();
    JLabel nameLabel = new JLabel("Name:");
    JTextField nameText = new JTextField();
    JPanel countryPanel = new JPanel();
    JLabel countryLabel = new JLabel("Country:");
    JTextField countryText = new JTextField();
    JPanel numberPanel = new JPanel();
    JLabel numberLabel = new JLabel("Number:");
    JTextField numberText = new JTextField();
    JButton OK = new JButton("OK");
    Goods newGood;

    public MyDialog() {
        super();
        setPreferredSize(new Dimension(FRAME_X, FRAME_Y));
        setContentPane(dialogPanel);
        dialogPanel.setLayout(new GridLayout(4, 1));
        namePanel.setLayout(new GridLayout(2, 1));
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        add(namePanel);
        countryPanel.setLayout(new GridLayout(2, 1));
        countryPanel.add(countryLabel);
        countryPanel.add(countryText);
        add(countryPanel);
        numberPanel.setLayout(new GridLayout(2, 1));
        numberPanel.add(numberLabel);
        numberPanel.add(numberText);
        add(numberPanel);
        add(OK);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Add an element");
        setLocationRelativeTo(null);
        pack();
    }

}
