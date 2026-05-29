package ctvrtak.PraktickaLite;

import javax.swing.*;
import java.awt.*;

public class CreateSupportTicket extends JFrame {
    JRadioButton lowOption, mediumOption, highOption, criticalOption;
    public CreateSupportTicket() {
        setLocationRelativeTo(null);
        setTitle("Vacation manager");
        setSize(700, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        JLabel employeeIDLabel = new JLabel("Employee ID: ");
        JTextField employeeIDField = new JTextField();

        JLabel departmentLabel = new JLabel("Department");
        JTextField departmentField = new JTextField();

        JLabel categoryLabel = new JLabel("Category: ");
        JTextField categoryField = new JTextField();

        JLabel priorityLabel = new JLabel("Priority");
        JPanel priorityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lowOption = new JRadioButton("Low");
        lowOption.setSelected(true);
        mediumOption = new JRadioButton("Medium");
        highOption = new JRadioButton("High");
        criticalOption = new JRadioButton("Critical");

        ButtonGroup priorityGroup = new ButtonGroup();
        priorityPanel.add(lowOption);
        priorityPanel.add(mediumOption);
        priorityPanel.add(highOption);
        priorityPanel.add(criticalOption);
        priorityGroup.add(criticalOption);
        priorityGroup.add(criticalOption);
        priorityGroup.add(criticalOption);
        priorityGroup.add(criticalOption);

        formPanel.add(employeeIDLabel);
        formPanel.add(employeeIDField);
        formPanel.add(departmentLabel);
        formPanel.add(departmentField);
        formPanel.add(categoryLabel);
        formPanel.add(categoryField);
        formPanel.add(priorityLabel);
        formPanel.add(priorityPanel);

        add(formPanel, BorderLayout.NORTH);

        JButton createTicketButton = new JButton("Create Ticket");
        createTicketButton.addActionListener(e -> {
            StringBuilder errors = new StringBuilder();
            if (employeeIDField.getText().isEmpty()) {
                errors.append("- Employee ID field cannot be empty.\n");
            } else if (!employeeIDField.getText().matches("E00[1-5]")) {
                errors.append("- Employee ID is allowed in format E001 - E005.\n");
            }
            if (departmentField.getText().isEmpty()) {
                errors.append("- Department field cannot be empty.\n");
            }
            if (categoryField.getText().isEmpty()) {
                errors.append("- Category field cannot be empty.\n");
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Following errors occurred:\n" + errors, "Errors", JOptionPane.ERROR_MESSAGE);
            } else {
                int lastTicketId = TicketHandle.supportTickets.getLast().getTicketId();
                SupportTicket st = new SupportTicket(
                        lastTicketId + 1,
                        employeeIDField.getText(),
                        departmentField.getText(),
                        categoryField.getText(),
                        getPriority(),
                        0,
                        "Open"

                );
                TicketHandle.supportTickets.add(st);
                JOptionPane.showMessageDialog(null, "Ok", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });


        add(createTicketButton, BorderLayout.SOUTH);
    }

    String getPriority() {
        if (lowOption.isSelected()) {
            return "Low";
        } else if (mediumOption.isSelected()) {
            return "Medium";
        } else if (highOption.isSelected()) {
            return "High";
        } else {
            return "Critical";
        }
    }
}
