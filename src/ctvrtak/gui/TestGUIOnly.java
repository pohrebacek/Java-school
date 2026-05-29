package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;

public class TestGUIOnly extends JFrame {

    final static int RESULTS = 110;

    public TestGUIOnly() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1000, 600);

        this.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        //northPanel.setBackground(Color.red);
        northPanel.setPreferredSize(new Dimension(150, 50));
        JLabel queryLabel = new JLabel("Query: ");
        JTextField tf = new JTextField(25);
        JButton goButton = new JButton("GO");
        northPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 20));
        northPanel.add(queryLabel);
        northPanel.add(tf);
        northPanel.add(goButton);


        JPanel southPanel = new JPanel();
        //southPanel.setBackground(Color.blue);
        southPanel.setPreferredSize(new Dimension(1000, 50));
        JLabel resultsLabel = new JLabel(String.valueOf(RESULTS)+" results");
        southPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 20));
        southPanel.add(resultsLabel);
        southPanel.add(resultsLabel);

        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.yellow);
        westPanel.setPreferredSize(new Dimension(200, 500));
        westPanel.setLayout(new GridLayout(5, 1));

        JRadioButton rbA = new JRadioButton("Option A");
        JRadioButton rbB = new JRadioButton("Option B");
        JRadioButton rbC = new JRadioButton("Option C");
        JRadioButton rbD = new JRadioButton("Option D");
        JRadioButton rbE = new JRadioButton("Option E");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbA);
        bg.add(rbB);
        bg.add(rbC);
        bg.add(rbD);
        bg.add(rbE);

        westPanel.add(rbA);
        westPanel.add(rbB);
        westPanel.add(rbC);
        westPanel.add(rbD);
        westPanel.add(rbE);

        JPanel centerPanel = new JPanel();
        //centerPanel.setBackground(Color.green);
        centerPanel.setLayout(new GridLayout(10, 11));

        for (int i = 0; i < RESULTS; i++) {
            JLabel label = new JLabel(String.valueOf(i+1));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
            centerPanel.add(label);

        }

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new TestGUIOnly().setVisible(true);
    }
}
