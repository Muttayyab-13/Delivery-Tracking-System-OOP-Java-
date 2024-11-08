/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author My University
 */
public class TrackOrders extends JFrame {

    public TrackOrders() {
        super("Track Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        String orderNumber = JOptionPane.showInputDialog("Enter Order Number");

        JTextArea orderDetailsArea = new JTextArea();
        orderDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderDetailsArea);

        String filePath = "Deliveries.txt";
        StringBuilder orderDetails = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingOrder = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order Number: " + orderNumber)) {
                    isReadingOrder = true;
                }

                if (isReadingOrder && !line.trim().isEmpty()) {
                    orderDetails.append(line).append("\n");
                }

                if (line.trim().equals("-----------") && isReadingOrder) {
                    break; // Stop reading after reaching the end of order details
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (orderDetails.length() == 0) {
            orderDetailsArea.setText("Order Number not found!");
        } else {
            orderDetailsArea.setText(orderDetails.toString());
        }

        add(scrollPane);
        setVisible(true);
    }
}