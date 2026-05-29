package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;

public class OwnComponent extends JFrame {

    public OwnComponent() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);

        this.setLayout(new GridLayout(2, 5));

        for (int i = 0; i < 10; i++) {
            this.add(new HeaderTile("nadpis", i));
        }
    }

    public static void main(String[] args) {
        new OwnComponent().setVisible(true);
    }
}

class HeaderTile extends JPanel {   //protože Panel může držet víc komponent
    String header;
    int num;

    public HeaderTile(String header, int num) {
        this.header = header;
        this.num = num;

        JLabel headerLabel = new JLabel(header);
        JLabel numLabel = new JLabel(String.valueOf(num));

        headerLabel.setFont(new Font("Consolas", Font.BOLD, 40));
        numLabel.setFont(new Font("Consolas", Font.BOLD, 40));

        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerLabel.setBackground(Color.yellow);
        numLabel.setBackground(Color.yellow);

        headerLabel.setOpaque(true);
        numLabel.setOpaque(true);

        this.setLayout(new GridLayout(2, 1));
        //this.setBorder(BorderFactory.);
    }
}
