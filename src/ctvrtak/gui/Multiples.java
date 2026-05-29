package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;

public class Multiples extends JFrame {

    public Multiples() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        JTextField tf = new JTextField("pico");
        JButton draw = new JButton("draw");

        tf.setFont(new Font("Consolas", Font.BOLD, 30));
        tf.setHorizontalAlignment(SwingConstants.CENTER);
        draw.setFont(new Font("Consolas", Font.BOLD, 30));

        draw.addActionListener(e -> {
            int number;
            try {
                number = Integer.parseInt(tf.getText());
                new GridPane(number).setVisible(true);
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Not a numebr");
            }
        });

        this.add(tf);
        this.add(draw);
        this.pack();
    }

    public static void main(String[] args) {
        new Multiples().setVisible(true);
    }
}
