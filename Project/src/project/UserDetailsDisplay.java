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
public class UserDetailsDisplay {

    public UserDetailsDisplay(String employeeNumber) {
        String filePath = "user_data.txt";
        StringBuilder userDetails = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingUser = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Employee Number: " + employeeNumber)) {
                    isReadingUser = true;
                }

                if (isReadingUser && !line.trim().isEmpty()) {
                    userDetails.append(line).append("\n");
                }

                if (line.trim().equals("-----------") && isReadingUser) {
                    break; // Stop reading after reaching the end of user details
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (userDetails.length() == 0) {
            JOptionPane.showMessageDialog(null, "Employee Number not found!");
        } else {
            ImageIcon oc=new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\icon.png");
            JOptionPane.showMessageDialog(null, userDetails.toString(),"Account Details",JOptionPane.PLAIN_MESSAGE,oc);
        }
    }
}
