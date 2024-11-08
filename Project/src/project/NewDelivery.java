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
public class NewDelivery extends JFrame {
    private JTextField nameField, dateField, addressField, phoneField, orderField, parcelField, destinationField, detailsField;

    public NewDelivery() {
        super("New Delivery");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);
        nameField = new JTextField();
        panel.add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        panel.add(dateLabel);
        dateField = new JTextField();
        panel.add(dateField);

        JLabel addressLabel = new JLabel("Address:");
        panel.add(addressLabel);
        addressField = new JTextField();
        panel.add(addressField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        panel.add(phoneLabel);
        phoneField = new JTextField();
        panel.add(phoneField);

        JLabel orderLabel = new JLabel("Order Number:");
        panel.add(orderLabel);
        orderField = new JTextField();
        panel.add(orderField);

        JLabel parcelLabel = new JLabel("Parcel Type:");
        panel.add(parcelLabel);
        parcelField = new JTextField();
        panel.add(parcelField);

        JLabel destinationLabel = new JLabel("Order Destination:");
        panel.add(destinationLabel);
        destinationField = new JTextField();
        panel.add(destinationField);

        JLabel detailsLabel = new JLabel("Order Details:");
        panel.add(detailsLabel);
        detailsField = new JTextField();
        panel.add(detailsField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener(this));
        panel.add(saveButton);

        add(panel);
        setVisible(true);
    }

    class SaveListener implements ActionListener {
        private NewDelivery frame;

        public SaveListener(NewDelivery frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String date = dateField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String order = orderField.getText();
            String parcel = parcelField.getText();
            String destination = destinationField.getText();
            String details = detailsField.getText();

            if (!order.isEmpty() && !destination.isEmpty() && !details.isEmpty()) {
                // Write details to a file
                try (FileWriter writer = new FileWriter("Deliveries.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    bufferedWriter.write("Order Number: " + order + "\n");
                    bufferedWriter.write("Name: " + name + "\n");
                    bufferedWriter.write("Date: " + date + "\n");
                    bufferedWriter.write("Address: " + address + "\n");
                    bufferedWriter.write("Phone Number: " + phone + "\n");
                    bufferedWriter.write("Order Number: " + order + "\n");
                    bufferedWriter.write("Parcel Type: " + parcel + "\n");
                    bufferedWriter.write("Order Destination: " + destination + "\n");
                    bufferedWriter.write("Order Details: " + details + "\n");
                    bufferedWriter.write("-----------\n");
                    JOptionPane.showMessageDialog(null, "Order Placed Successfully");
                    frame.dispose();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error placing Order!");
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter all details!");
            }
        }
    }
}


