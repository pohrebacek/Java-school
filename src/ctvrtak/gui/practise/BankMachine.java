package ctvrtak.gui.practise;

import javax.swing.*;
import java.awt.*;

public class BankMachine {
    public static void main(String[] args) {
        new InputWindow().setVisible(true);
    }
}

class InputWindow extends JFrame {

    public InputWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        JTextField input = new JTextField("Value");
        input.setPreferredSize(new Dimension(500, 100));
        input.setFont(new Font("Consolas", Font.BOLD, 24));
        input.setHorizontalAlignment(SwingConstants.CENTER);

        JButton inButton = new JButton("Go");
        inButton.addActionListener(e -> {
            try {
                int number = Integer.parseInt(input.getText());
                if (number <= 0) {
                    JOptionPane.showMessageDialog(null, "Zadejte kladné číslo"); //proč null?
                } else {
                    //ResultWindow.getNominals(number);
                    new ResultWindow(number).setVisible(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Zadejte číslo");
            }
        });
        inButton.setPreferredSize(new Dimension(100, 100));
        inButton.setFont(new Font("Consolas", Font.BOLD, 32));

        this.add(input);
        this.add(inButton);

        this.pack();
    }
}

class ResultWindow extends JFrame {
    final static int[] values = {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    int number;
    static void getNominals(int number, JPanel panel) {
        int amount = 0;
        for (int value : values) {
            amount = 0;
            if (number >= value) {
                amount = number / value;
                System.out.println(amount + "x" + value);
                number -= amount*value;
            } else {
                System.out.println("0x" + value);
            }
            panel.add(new BankTile(value, amount));

        }

    }
    public ResultWindow(int number) {
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.number = number;
        JLabel totalValue = new JLabel(String.valueOf(number));
        totalValue.setPreferredSize(new Dimension(400, 100));
        totalValue.setHorizontalAlignment(SwingConstants.CENTER);
        totalValue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        totalValue.setFont(new Font("Consolas", Font.BOLD, 32));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 4, 3, 3));
        gridPanel.setPreferredSize(new Dimension(400, 300));

        this.add(totalValue, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);

        getNominals(number, gridPanel);

        this.pack();
    }

}

class BankTile extends JPanel {
    BankTile(int value, int amount) {
        this.setLayout(new GridLayout(2, 1));
        JLabel valueLabel = new JLabel(String.valueOf(value));
        JLabel amountLabel = new JLabel(amount + "x");

        valueLabel.setFont(new Font("Consolas", Font.BOLD, 24));
        amountLabel.setFont(new Font("Consolas", Font.BOLD, 24));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        amountLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.setOpaque(true);

        if (amount > 0) {
            this.setBackground(Color.green);
        } else {
            this.setBackground(Color.red);
        }

        this.add(amountLabel);
        this.add(valueLabel);
    }
}
