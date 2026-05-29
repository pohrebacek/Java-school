package ctvrtak.gui.bloodTestTest;

import ctvrtak.gui.booking.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class BloodTest extends JFrame {

    public static ArrayList<Donation> donations;

    public BloodTest(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        donations = new ArrayList<>();

        JButton listButton = new JButton("List Donations");
        listButton.addActionListener(e -> {
            for(Donation d : donations){
                System.out.println(d);
            }
        });

        JButton reserveButton = new JButton("New reservation");

        reserveButton.addActionListener(e -> {
            new DonationForm().setVisible(true);
        });

        donations.add(new Donation("Tester", "Male", false, LocalDate.now().minusMonths(2)));

        add(listButton);
        add(reserveButton);
        pack();
    }


    public static void main(String[] args) {
        BloodTest bt = new BloodTest();
        bt.setVisible(true);
    }
}

class Donation {
    String name;
    String gender;
    boolean firstTimer;
    LocalDate date;

    public Donation(String name, String gender, boolean firstTimer, LocalDate date) {
        this.name = name;
        this.gender = gender;
        this.firstTimer = firstTimer;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isFirstTimer() {
        return firstTimer;
    }

    public void setFirstTimer(boolean firstTimer) {
        this.firstTimer = firstTimer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", firstTimer=" + firstTimer +
                ", date=" + date +
                '}';
    }
}

class DonationForm extends JFrame {

    //Pravidla:
    //1. Date/Name nesmi byt prazdny
    //Pokud nedaruje prvne, kontroluje se:
    //Jestli nekdo s tim jmenem uz v listu neni a pokud ano, kontroluje se:
    //pokud zena: alespon 120 dni od mezi darovanim
    //pokud muz: alespon 90 dni mezi darovanim

    JRadioButton maleRadio, femaleRadio;

    public DonationForm() {
        this.setSize(700, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        JPanel formPanel = new JPanel();

        formPanel.setLayout(new GridLayout(4, 2));
        buttonsPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Full name:");
        formPanel.add(nameLabel);
        JTextField nameField = new JTextField();
        formPanel.add(nameField);
        JLabel genderLabel = new JLabel("Gender:");
        formPanel.add(genderLabel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout());
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        maleRadio.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadio);
        bg.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formPanel.add(genderPanel);

        JLabel firstTimeLabel = new JLabel("First time donor:");
        formPanel.add(firstTimeLabel);
        JCheckBox firstTimeCheckBox = new JCheckBox("First time donor");
        formPanel.add(firstTimeCheckBox);

        JLabel dateLabel = new JLabel("Date (dd-MM-yyyy):");
        formPanel.add(dateLabel);
        JTextField dateField = new JTextField();
        formPanel.add(dateField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        okButton.addActionListener(e -> {
            StringBuilder errors = new StringBuilder();
            if (nameField.getText().isEmpty()) {
                errors.append("- Jméno nesmí být prázdné!\n");
            }
            if (dateField.getText().isEmpty()) {
                errors.append("- Datum nesmí být prázdné!\n");
            }
            if (!firstTimeCheckBox.isSelected()) {
                for (Donation d : BloodTest.donations) {
                    if (d.name.equals(nameField.getText())) {   //lepší dát přes stream
                        long daysBetween = ChronoUnit.DAYS.between(d.getDate(), parseDate(dateField.getText()));
                        if (d.gender.equals("Female") && daysBetween < 120) {
                            errors.append("- Od vašeho posledního darování musíuběhnout alespoň 120 dní");
                            break;
                        }
                        if (d.gender.equals("Male") && daysBetween < 90) {
                            errors.append("- Od vašeho posledního darování musíuběhnout alespoň 90 dní");
                            break;
                        }
                    }
                }
            }
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Following errors occurred:\n" + errors, "Errors", JOptionPane.ERROR_MESSAGE);
            } else {
                Donation donation = new Donation(
                        nameField.getText(),
                        getFormGender(),
                        firstTimeCheckBox.isSelected(),
                        parseDate(dateField.getText())
                );
                BloodTest.donations.add(donation);
                JOptionPane.showMessageDialog(null, "Ok", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });


        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(formPanel, BorderLayout.CENTER);
    }

    String getFormGender(){
        if (maleRadio.isSelected()){
            return "Male";
        } else {
            return "Female";
        }
    }

    Donation getDonation() {
        return null;
    }

    public static LocalDate parseDate(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            return LocalDate.parse(text, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Vyplňte správný formát datumu", "Errors", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Ma byt: dd-MM-yyyy, je: " + text);
        }
    }

}
