/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author My University
 */
public class RegistrationFrame extends JFrame {
    private JTextField usernameField, passwordField, nameField, addressField, phoneField, employeeField;


    public RegistrationFrame() {
        super("Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);
        nameField = new JTextField();
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        panel.add(addressLabel);
        addressField = new JTextField();
        panel.add(addressField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        panel.add(phoneLabel);
        phoneField = new JTextField();
        panel.add(phoneField);

        JLabel employeeLabel = new JLabel("Employee Number:");
        panel.add(employeeLabel);
        employeeField = new JTextField();
        panel.add(employeeField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener(this));
        panel.add(saveButton);

        add(panel);
        setVisible(true);
    }

    class SaveListener implements ActionListener {
        private RegistrationFrame frame;
        
        public SaveListener(RegistrationFrame frame) {
        this.frame=frame;
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            String username = usernameField.getText();
            String password = passwordField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String employee = employeeField.getText();

            // Write details to a file
            if(name.isEmpty()!=true)
            {
            try (FileWriter writer = new FileWriter("user_data.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write("Employee Number: " + employee + "\n");
                bufferedWriter.write("Username: " + username + "\n");
                bufferedWriter.write("Password: " + password + "\n");
                bufferedWriter.write("Name: " + name + "\n");
                bufferedWriter.write("Address: " + address + "\n");
                bufferedWriter.write("Phone Number: " + phone + "\n");
                
                bufferedWriter.write("-----------\n");
                JOptionPane.showMessageDialog(null, "Details saved!");
                
                frame.dispose();
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving details!");
                ex.printStackTrace();
            }
        }
            else
            {
               JOptionPane.showMessageDialog(null, "Enter Full details!"); 
            }
    }
}
}