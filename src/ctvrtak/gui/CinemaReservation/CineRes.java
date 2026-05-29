package ctvrtak.gui.CinemaReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CineRes extends JFrame {
    static int gridRows = 6;
    static int gridCols = 5;
    static int[][] seats = new int[gridRows][gridCols];

    public CineRes() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(gridRows, gridCols));


        
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                this.add(new Seat());
            }
        }
    }

    public static void main(String[] args) {
        new CineRes().setVisible(true);
    }
}


class Seat extends JLabel {

    boolean clicked = false;

    public Seat() {
        this.setText(" ");
        this.setFont(new Font("Consolas", Font.BOLD, 30));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setOpaque(true);



        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (clicked) {
                    setBackground(null);
                    clicked = false;
                } else {
                    setBackground(Color.GREEN);
                    clicked = true;
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
