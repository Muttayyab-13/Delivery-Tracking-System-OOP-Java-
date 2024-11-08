/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static project.UpdateOrderInfo.DeliveryDataUpdater.updateDeliveryInfo;


/**
 *
 * @author My University
 */
public class UpdateOrderInfo extends JFrame {

    public UpdateOrderInfo() {
        super("Update Order Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel orderNumberLabel = new JLabel("Order Number:");
        orderNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField orderNumberField = new JTextField();

        JLabel destinationLabel = new JLabel("Order Destination:");
        destinationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField destinationField = new JTextField();

        JLabel detailsLabel = new JLabel("Order Details:");
        detailsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField detailsField = new JTextField();

       JButton updateButton = new JButton("Update");
    updateButton.addActionListener(e -> {
        String orderNumber = orderNumberField.getText();
        String destination = destinationField.getText();
        String details = detailsField.getText();

        boolean isValidOrder = checkOrderNumberValidity(orderNumber);

        if (isValidOrder && !destination.isEmpty() && !details.isEmpty()) {
            updateDeliveryInfo(orderNumber, destination, details);
            JOptionPane.showMessageDialog(null, "Order Information Updated Successfully!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Order Number or Please fill in all fields.");
        }
    });


   

        panel.add(orderNumberLabel);
        panel.add(orderNumberField);
        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(detailsLabel);
        panel.add(detailsField);
        panel.add(new JLabel()); // Placeholder
        panel.add(updateButton);

        add(panel);
        setVisible(true);
    }

 
public class DeliveryDataUpdater {
    public static void updateDeliveryInfo(String orderNumber, String updatedDestination, String updatedDetails) {
        File file = new File("Deliveries.txt");
        File tempFile = new File("temp_delivery.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean foundEntry = false;
            boolean inEntry = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order Number: " + orderNumber)) {
                    foundEntry = true;
                    inEntry = true;
                    writer.write(line + "\n");
                } else if (inEntry && line.startsWith("Order Destination:")) {
                    writer.write("Order Destination: " + updatedDestination + "\n");
                } else if (inEntry && line.startsWith("Order Details:")) {
                    writer.write("Order Details: " + updatedDetails + "\n");
                    writer.write("-----------\n");
                    inEntry = false;
                } else {
                    if (!inEntry) {
                        writer.write(line + "\n");
                    }
                }
            }

            if (!foundEntry) {
                System.out.println("Order Number not found!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (!file.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        if (!tempFile.renameTo(file)) {
            System.out.println("Could not rename file");
        }
    
    }
  }

 private boolean checkOrderNumberValidity(String orderNumber) {
        String filePath = "Deliveries.txt";
        boolean isValid = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order Number: " + orderNumber)) {
                    isValid = true;
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return isValid;
    }
}
