package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GridPane extends JFrame {

 public GridPane(int dim) throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(dim, dim));
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if ((i+j)%2 == 1) {
                    this.add(new Piece(Color.RED));
                } else {
                    this.add(new Piece(Color.blue));
                }
            }

        }
        this.setSize(450, 450);
        //this.pack();
    }

    public static void main(String[] args) {
        new GridPane(10).setVisible(true);
    }


}

class Piece extends JLabel {    //prostě na custom častý komponenty

    static Color HOVER_COLOR = Color.ORANGE;
    static Color CLICK_COLOR = Color.magenta;
    static boolean clicked = false;

    public Piece(Color color) {
        this.setText(" ");
        this.setFont(new Font("Consolas", Font.BOLD, 30));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setOpaque(true);
        this.setBackground(color);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(CLICK_COLOR);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!clicked) {
                    setBackground(HOVER_COLOR);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (clicked) {
                    setBackground(color);
                }
            }
        });
    }
}
