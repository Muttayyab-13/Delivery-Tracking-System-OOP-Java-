/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author My University
 */
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PendingDeliveries extends JFrame {

    public PendingDeliveries() {
        super("Pending Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea pendingOrdersArea = new JTextArea();
        pendingOrdersArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(pendingOrdersArea);

        StringBuilder pendingOrders = new StringBuilder();
        String filePath = "Deliveries.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingOrder = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    isReadingOrder = true;
                }

                if (isReadingOrder && !line.trim().isEmpty()) {
                    pendingOrders.append(line).append("\n");
                }

                if (line.trim().equals("-----------") && isReadingOrder) {
                    pendingOrders.append("-----------\n\n");
                    isReadingOrder = false;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        pendingOrdersArea.setText("Pending Orders:\n\n" + pendingOrders.toString());

        add(scrollPane);
        setVisible(true);
    }
}