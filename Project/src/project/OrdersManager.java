
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
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdersManager extends JFrame {

    public OrdersManager() {
        super("Orders Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250, 300);
        this.getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
            setVisible(true);
            this.setLayout(null);

        JButton button1 = new JButton("Pending Orders");
        button1.setBounds(40, 20, 150, 50);
        this.add(button1);
        
        JButton button2 = new JButton("Finish Order");
        button2.setBounds(40, 90, 150, 50);
        this.add(button2);
        
        JButton button3 = new JButton("Completed Orders");
        
        button3.setBounds(40, 160, 150, 50);
        this.add(button3);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Button 1 clicked!");
                PendingDeliveries o=new PendingDeliveries();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Button 2 clicked!");
                CompleteOrder o1=new CompleteOrder();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Button 3 clicked!");
                CompletedOrders o2=new CompletedOrders();
            
            
            }
        });

      
    
    }
}