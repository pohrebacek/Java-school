package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSaver extends JFrame {

    public ScreenSaver() {
        Canvas panel = new Canvas();
        this.add(panel);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

    }

    public static void main(String[] args) {
        new ScreenSaver().setVisible(true);
    }
}

class Canvas extends JPanel implements ActionListener {
    final int CANVAS_WIDTH = 1200;
    final int CANVAS_HEIGHT = 1200;
    Image bouncing;
    int x = 0;
    int y = 0;
    int xVelocity = 100;
    int yVelocity = 100;
    Canvas() {
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setBackground(Color.BLACK);
        bouncing = new ImageIcon("solaire.png").getImage();
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bouncing, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= CANVAS_WIDTH - bouncing.getWidth(null) || x < 0) {
            xVelocity*= -1;
        }
        if (y >= CANVAS_HEIGHT - bouncing.getHeight(null) || y < 0) {
            yVelocity*= -1;
        }
        x += xVelocity;
        y += yVelocity;
        repaint();
    }
}
