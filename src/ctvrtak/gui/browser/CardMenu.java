package ctvrtak.gui.browser;

import javax.swing.*;
import java.awt.*;

public class CardMenu extends JFrame {
    JLabel fullName, salary, shoeSize;
    ImageIcon avatar;
    JPanel lowerMenu;
    JButton next, previous, first, last;
    int cursor;

    CardMenu(){
        cursor = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        lowerMenu = new JPanel();
        lowerMenu.setLayout(new FlowLayout());


        fullName = new JLabel();
        salary = new JLabel();
        shoeSize = new JLabel();

        fullName.setFont(new Font("MV Boli", Font.BOLD, 18));
        salary.setFont(new Font("MV Boli", Font.BOLD, 18));
        shoeSize.setFont(new Font("MV Boli", Font.BOLD, 18));

//        avatar = MainMenu.personData.get(0).avatar;//zaciname na prvnim
        avatar = new ImageIcon(MainMenu.personData.get(cursor).avatar.getImage().getScaledInstance(600,450, Image.SCALE_DEFAULT));
        fullName.setText("Full name: " + MainMenu.personData.get(cursor).name + " " + MainMenu.personData.get(cursor).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(cursor).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(cursor).salary);

        fullName.setIcon(avatar);
        fullName.setHorizontalTextPosition(JLabel.CENTER);
        fullName.setVerticalTextPosition(JLabel.TOP);
        fullName.setIconTextGap(5);
        fullName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(fullName, BorderLayout.CENTER);

        previous = new JButton("Previous");
        next = new JButton("Next");
        first = new JButton("First");
        last = new JButton("Last");
        previous.setEnabled(false);
        lowerMenu.add(first);
        lowerMenu.add(previous);
        lowerMenu.add(shoeSize);
        lowerMenu.add(salary);
        lowerMenu.add(next);
        lowerMenu.add(last);

        first.addActionListener(e -> {
            previous.setEnabled(false);
            next.setEnabled(true);
            setPerson(0);
        });

        last.addActionListener(e -> {
            previous.setEnabled(true);
            next.setEnabled(false);
            setPerson(MainMenu.personData.size() -1);
        });

        next.addActionListener(e -> {
            previous.setEnabled(true);
            setPerson(cursor+1);
        });

        previous.addActionListener(e -> {
            next.setEnabled(true);
            setPerson(cursor-1);
        });

        this.add(lowerMenu, BorderLayout.SOUTH);
        this.pack();
    }

    public void setPerson(int cursor) {
        this.cursor = cursor;
        avatar = new ImageIcon(MainMenu.personData.get(cursor).avatar.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT));
        fullName.setText("Full name: " + MainMenu.personData.get(cursor).name + " " + MainMenu.personData.get(cursor).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(cursor).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(cursor).salary);

        fullName.setIcon(avatar);

        if (cursor == 0) {
            previous.setEnabled(false);
        }

        if (cursor == MainMenu.personData.size()-1) {
            next.setEnabled(false);
        }
    }

}


