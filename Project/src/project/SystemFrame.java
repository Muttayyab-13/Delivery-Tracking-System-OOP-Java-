/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author My University
 */
public class SystemFrame extends JFrame {

    public SystemFrame(String username) {
        super("Welcome, " + username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500); // Set a larger frame size
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Top left button
        JButton topLeftButton = new JButton();
        ImageIcon o1=new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\imageacc.png");
            topLeftButton.setIcon(o1);
        topLeftButton.addActionListener(e -> {
            
            //JOptionPane.showMessageDialog(null, " ------My Account------ ");
            String emp=JOptionPane.showInputDialog("Enter Employee Number");
           UserDetailsDisplay one=new UserDetailsDisplay(emp);
            
        });
        panel.add(topLeftButton, BorderLayout.NORTH);

        /*JLabel welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);*/

        // Bottom right buttons
         JPanel bottomRightPanel = new JPanel(new GridLayout(3, 1));
         
         
        JButton adminButton = new JButton("Pending and Completed Orders Manager");
        adminButton.addActionListener(e -> {
            
            OrdersManager o3=new OrdersManager();
            
            
            //JOptionPane.showMessageDialog(null, "Admin clicked");
        });
        bottomRightPanel.add(adminButton);
   
         
         JButton termsButton = new JButton();
         ImageIcon ic3 = new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\terms.png");
         termsButton.setIcon(ic3);
        termsButton.addActionListener(e -> {
            
            TermsAndConditions one=new TermsAndConditions();
            //JOptionPane.showMessageDialog(null, "Terms and Conditions clicked");
        });
        bottomRightPanel.add(termsButton);
        
        
        JButton updateOrderButton = new JButton();
        ImageIcon ic2 = new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\logout.png");
        updateOrderButton.setIcon(ic2);
        updateOrderButton.addActionListener(e -> {
             dispose(); // Close the system frame
            
            JOptionPane.showMessageDialog(null, "Logged Out Successfully!", "LOGOUT ", JOptionPane.PLAIN_MESSAGE, ic2);
            new CourierManagementSystem(); // Open the login frame
            
            
            //JOptionPane.showMessageDialog(null, "Update Order Information clicked");
        });
        bottomRightPanel.add(updateOrderButton);
        

        panel.add(bottomRightPanel, BorderLayout.SOUTH);

        // Center panel for other buttons
        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        
        
        JButton newDeliveryButton = new JButton("New Order");
        ImageIcon ic6 = new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\new.png");
        newDeliveryButton.setIcon(ic6);
        newDeliveryButton.setBounds(50, 50, 50, 50);
        newDeliveryButton.addActionListener(e -> {
            NewDelivery on11=new NewDelivery();
            //JOptionPane.showMessageDialog(null, "New Delivery clicked");
        });
        centerPanel.add(newDeliveryButton);

        JButton trackOrdersButton = new JButton("Track Orders");
        ImageIcon ic5 = new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\trk.png");
        trackOrdersButton.setIcon(ic5);
        trackOrdersButton.addActionListener(e -> {
            TrackOrders t=new TrackOrders();
            //JOptionPane.showMessageDialog(null, "Track Orders clicked");
        });
        centerPanel.add(trackOrdersButton);

        JButton logoutButton = new JButton("Update Order Info");
        ImageIcon ic4 = new ImageIcon("C:\\Users\\My University\\Desktop\\Project\\src\\project\\update.png");
        logoutButton.setIcon(ic4);
        logoutButton.addActionListener(e -> {
            UpdateOrderInfo o=new UpdateOrderInfo();
           
        });
        centerPanel.add(logoutButton);

        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}