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

    
    public class CourierManagementSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public CourierManagementSystem() {
        super("Courier Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        
        ImageIcon ic=new ImageIcon("src\\project\\user.png");
        JLabel userLabel = new JLabel("Username:");
        userLabel.setIcon(ic);
        userLabel.setIconTextGap(25);
        panel.add(userLabel);
        

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        ImageIcon ic1=new ImageIcon("src\\project\\login-password-3.png");
        passLabel.setIconTextGap(25);
        passLabel.setIcon(ic1);
        
        panel.add(passLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginListener());
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterListener());
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

     class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticate(username, password)) {
                ImageIcon ic2=new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\icon.png");
                
                JOptionPane.showMessageDialog(null, "Login Successful!", "LOGIN ", JOptionPane.PLAIN_MESSAGE, ic2);

                // Open a new frame or perform actions after successful login
                SystemFrame one =new SystemFrame(username); // Open the new frame
                dispose(); // Close the login frame
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            RegistrationFrame one=new RegistrationFrame();
            
            /*
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
                // Write username and password to a file for registration
                try (FileWriter writer = new FileWriter("user_data.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    bufferedWriter.write(username + ":" + password + "\n");
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error registering user!");
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter username and password!");
            }*/
        }
    }
    


 private boolean authenticate(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
        String line;
        boolean foundUser = false;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Username:") && line.substring(10).trim().equals(username)) {
                foundUser = true;
            }
            if (foundUser && line.startsWith("Password:") && line.substring(10).trim().equals(password)) {
                return true; // Found a matching username and password
            }
            if (line.equals("-----------")) {
                foundUser = false; // Reset when reaching the end of an entry
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false; // No matching username and password found

 }

    private void openSystemFrame(String username) {
         SystemFrame systemFrame = new SystemFrame("Welcome, " + username);
        systemFrame.setSize(500, 300);
        systemFrame.setLocationRelativeTo(null);

        // Add components or functionality for the system frame here...

        systemFrame.setVisible(true);
    }
    
    }
    

