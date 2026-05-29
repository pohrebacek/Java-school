package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;

public class Sliding extends JFrame {

    public Sliding() {
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JSlider slider = new JSlider(-100, 100, 20);
        slider.setPreferredSize(new Dimension(400, 200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(50);

        slider.setPaintLabels(true);

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("°C = " + slider.getValue());
        slider.addChangeListener(l -> {
            label.setText("°C = " + slider.getValue());
        });

        panel.add(slider);
        panel.add(label);
        this.add(panel);
    }

    public static void main(String[] args) {
        new Sliding().setVisible(true);
    }
}
