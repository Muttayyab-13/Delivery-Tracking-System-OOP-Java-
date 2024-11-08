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
import java.io.*;

public class CompletedOrders extends JFrame {

    public CompletedOrders() {
        super("Completed Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea completedOrdersArea = new JTextArea();
        completedOrdersArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(completedOrdersArea);

        StringBuilder completedOrders = new StringBuilder();
        String filePath = "Complete.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingOrder = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order Number: ")) {
                    isReadingOrder = true;
                }

                if (isReadingOrder && !line.trim().isEmpty()) {
                    completedOrders.append(line).append("\n");
                }

                if (line.trim().equals("-----------") && isReadingOrder) {
                    completedOrders.append("-----------\n\n");
                    isReadingOrder = false;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        completedOrdersArea.setText("Completed Orders:\n\n" + completedOrders.toString());

        add(scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CompletedOrders::new);
    }
}
