package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;

public class Labeling extends JFrame {

    public Labeling() {
        this.setSize(750, 400);
        this.setTitle("First window example");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("test");  //vytvoří label s textem "test"

        label.setForeground(new Color(0xff050f));
        label.setBackground(Color.black);
        label.setOpaque(true);  //nefacha bez něj background

        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 64));

        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(null);   //díky tomu můžu ty kokotiny pozicovat sám a nemá to tedy přednastavenej layout, tudít to neroztáhne label přes celý okno
        label.setBounds(this.getWidth()/2, this.getHeight()/2, 200, 200);
        this.add(label);    //musim přidat k oknu label
    }

    public static void main(String[] args) {
        new Labeling().setVisible(true);
    }
}
