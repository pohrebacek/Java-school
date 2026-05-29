package ctvrtak.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldOptions extends JFrame implements ActionListener {

    JTextField tf;
    JRadioButton enButton, disButton;

    public TextFieldOptions() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setSize(700, 200);

        tf = new JTextField("text");
        tf.setFont(new Font("Arial", Font.PLAIN, 48));
        //tf.setSize(200, 300); //-> nefdunguje pro tf jako nastavení velikosti
        tf.setPreferredSize(new Dimension(350, 100)); //musí se použít tohle
        tf.setBackground(Color.yellow);
        tf.setHorizontalAlignment(SwingConstants.CENTER);
        //tf.getText()
        //tf.setText();
        //this.pack(); //dělá to že nastaví okno tak, aby se do něj vše vešlo a nebylo kolem prázdný místo

        enButton = new JRadioButton("Enable");
        enButton.setFont(new Font("Arial", Font.PLAIN, 28));
        enButton.setBackground(Color.blue);
        enButton.setForeground(Color.magenta);

        enButton.setSelected(true);

        disButton = new JRadioButton("disable");
        disButton.setFont(new Font("Arial", Font.PLAIN, 28));

        ButtonGroup group = new ButtonGroup();  //dává buttony do groups, takže funguje to že v jedný group může bejt selected jen jeden radio button
        group.add(enButton);
        group.add(disButton);

        enButton.addActionListener(this);
        disButton.addActionListener(this);

        JCheckBox ch = new JCheckBox("Text");
        this.add(ch);

        this.add(tf);
        this.add(enButton);
        this.add(disButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enButton ||e.getSource() == disButton){
            if (enButton.isSelected()) {
                tf.setEnabled(true);
            } else {
                tf.setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new TextFieldOptions().setVisible(true);
    }
}
