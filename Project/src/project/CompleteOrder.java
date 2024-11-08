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

public class CompleteOrder extends JFrame {

    public CompleteOrder() {
        super("Complete Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        String orderNumber = JOptionPane.showInputDialog("Enter Order Number");
        String filePath = "Deliveries.txt";
        String completeFilePath = "Complete.txt";

        boolean orderFound = false;
        StringBuilder orderDetails = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order Number: " + orderNumber)) {
                    orderFound = true;
                    orderDetails.append(line).append("\n");
                    for (int i = 0; i < 5; i++) {
                        orderDetails.append(reader.readLine()).append("\n");
                    }
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (orderFound) {
            try (FileWriter writer = new FileWriter(completeFilePath, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(orderDetails.toString());
                bufferedWriter.newLine();
                JOptionPane.showMessageDialog(null, "Order Finished");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Remove order from Deliveries.txt
            try {
                File inputFile = new File(filePath);
                File tempFile = new File("temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String lineToRemove = "Order Number: " + orderNumber;
                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    if (!currentLine.equals(lineToRemove) && !currentLine.equals("-----------")) {
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }

                writer.close();
                reader.close();
                tempFile.renameTo(inputFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Order Number not found!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CompleteOrder::new);
    }
}
