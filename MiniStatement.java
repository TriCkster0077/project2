import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        JLabel mini = new JLabel("");
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            conn c = new conn();
            ResultSet rs =c.s.executeQuery("SELECT * FROM login WHERE pin = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,8)+"XXXXXX"+rs.getString("cardnumber").substring(14));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            conn c = new conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is " + bal);
        }catch (Exception e){
            System.out.println(e);
        }

        setLayout(null);
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
