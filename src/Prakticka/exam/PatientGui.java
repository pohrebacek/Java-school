package exam;

import javax.swing.*;
import java.awt.*;

/**
 * GUI pro pridani mereni.
 */
public class PatientGui extends JFrame {
    JTextField patientIdField, minuteField, oxygenField, systolicField, diastolicField;
    StringBuilder errors;
    private static final int DEFAULT_BPM = 98;

    public static void init() {
        new PatientGui().setVisible(true);
    }

    public PatientGui() {
        // TODO: vytvorit formular
        setLocationRelativeTo(null);
        setTitle("New measurement");
        setSize(400, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 5));
        JLabel patientIdLabel = new JLabel("Patient ID: ");
        patientIdField = new JTextField();
        JLabel minuteLabel = new JLabel("Minute: ");
        minuteField = new JTextField();
        JLabel oxygenLabel = new JLabel("Oxygen: ");
        oxygenField = new JTextField();
        JLabel bloodPressureLabel = new JLabel("Blood pressure: ");

        JPanel bloodPressurePanel = new JPanel();
        bloodPressurePanel.setLayout(new FlowLayout());
         systolicField = new JTextField();
        JLabel slash = new JLabel("/");
         diastolicField = new JTextField();
        systolicField.setPreferredSize(new Dimension(50, 20));
        diastolicField.setPreferredSize(new Dimension(50, 20));
        bloodPressurePanel.add(systolicField);
        bloodPressurePanel.add(slash);
        bloodPressurePanel.add(diastolicField);

        JLabel blankLabel = new JLabel();
        JCheckBox patientIsConscious = new JCheckBox("Patient is Conscious");


        formPanel.add(patientIdLabel);
        formPanel.add(patientIdField);
        formPanel.add(minuteLabel);
        formPanel.add(minuteField);
        formPanel.add(oxygenLabel);
        formPanel.add(oxygenField);
        formPanel.add(bloodPressureLabel);
        formPanel.add(bloodPressurePanel);
        formPanel.add(blankLabel);
        formPanel.add(patientIsConscious);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            errors = new StringBuilder();
            if (patientIdField.getText().isEmpty()) {
                errors.append("- Patient ID field cannot be empty.\n");
            } else if (!Run.doesPatientExist(patientIdField.getText())) {
                errors.append("- Patient doesnt exist.\n");
            }

            if (minuteField.getText().isEmpty()) {
                errors.append("- Minute field cannost be empty.\n");
            } else if (!checkIfDigit(minuteField)) {
                errors.append("- Only digits allowed for minute field.\n");
            } else if (Integer.parseInt(minuteField.getText()) < 0 && checkIfDigit(minuteField)) {
                errors.append("- Minutes cannot be negative.\n");
            }

            if (oxygenField.getText().isEmpty()) {
                errors.append("- Oxygen field cannot be empty.\n");
            } else if (!checkIfDigit(oxygenField)) {
                errors.append("- Only digits allowed for oxygen field.\n");
            } else if (Integer.parseInt(oxygenField.getText()) < 0 && Integer.parseInt(oxygenField.getText()) > 100 && checkIfDigit(oxygenField)) {
                errors.append("- Oxygen is only allowed in range 0 - 100.\n");
            }

            if (systolicField.getText().isEmpty() || diastolicField.getText().isEmpty()) {
                errors.append("- Blood pressure field cannot be empty.\n");
            } else if (!checkIfDigit(systolicField) || !checkIfDigit(diastolicField)) {
                errors.append("- Only digits allowed for blood pressure field.\n");
            }else if (Integer.parseInt(systolicField.getText()) <= Integer.parseInt(diastolicField.getText()) && (checkIfDigit(systolicField) && checkIfDigit(diastolicField))) {
                errors.append("- Systolic field must be greater than diastolic field.\n");
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Following errors occurred:\n" + errors, "Errors", JOptionPane.ERROR_MESSAGE);
            } else {
                Measurement newMeasurement = new Measurement(
                        patientIdField.getText(),
                        Integer.parseInt(minuteField.getText()),
                        Integer.parseInt(oxygenField.getText()),
                        DEFAULT_BPM,
                        Integer.parseInt(systolicField.getText()),
                        Integer.parseInt(diastolicField.getText())
                );
                Run.measurements.add(newMeasurement);
                JOptionPane.showMessageDialog(null, "Ok", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        add(formPanel, BorderLayout.NORTH);
        add(saveButton, BorderLayout.SOUTH);
    }

    boolean checkIfDigit(JTextField field) {
        boolean isDigit = true;
        for (int i = 0; i < diastolicField.getText().length(); i++) {
            if (!Character.isDigit(diastolicField.getText().charAt(i))) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }
}
