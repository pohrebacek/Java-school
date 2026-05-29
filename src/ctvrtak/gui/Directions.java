package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Directions extends JFrame implements KeyListener {

    JLabel block;

    public Directions() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        block = new JLabel();
        block.setBounds(0, 0, 50, 50);
        block.setBackground(Color.red);
        block.setOpaque(true);

        this.addKeyListener(this);  //proč this?
        this.add(block);
    }

    public static void main(String[] args) {
        new Directions().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':   block.setLocation(block.getX()-10, block.getY());
                break;
            case 'd':   block.setLocation(block.getX()+10, block.getY());
                break;
            case 'w':   block.setLocation(block.getX(), block.getY()-10);
                break;
            case 's':   block.setLocation(block.getX(), block.getY()+10);
                    break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Zmacknuto: " + e.getKeyChar());
        System.out.println("Zmacknuto: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
