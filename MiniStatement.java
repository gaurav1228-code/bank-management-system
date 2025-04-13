package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{

    JButton b1, b2;
    JLabel l1;
    JTextPane textPane;
    JScrollPane scrollPane;

    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        textPane = new JTextPane();
        textPane.setEditable(false);

        scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(20, 20, 360, 60);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            if (rs.next()) {
                String cardNumber = rs.getString("cardno");
                l2.setText("Card Number: " + cardNumber);
            }
        }catch(Exception e){

        }

        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");
            StringBuilder statementText = new StringBuilder();
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                statementText.append(date).append("  ").append(type).append("  ").append(amount).append("\n");
            }
            textPane.setText(statementText.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);
        scrollPane.setBounds(20, 80, 360, 400);
        l1.setBounds(20, 140, 400, 200);
        l4.setBounds(20, 400, 400, 20);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }

}