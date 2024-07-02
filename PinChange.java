import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader .getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500, 35);
        image.add(text);

        JLabel pinText = new JLabel("NEW PIN: ");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(165,320,180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel rePinText = new JLabel("Re-Enter NEW PIN: ");
        rePinText.setForeground(Color.white);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        rePinText.setBounds(165,360,180, 25);
        image.add(rePinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "ENTERED PIN DOESN'T MATCH");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                    return;
                }
                conn c = new conn();
                String query1 = "update bank set pin = '"+npin+"'where pin = '"+pinNumber+"'";
                String query2 = "update login set pin = '"+npin+"'where pin = '"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+npin+"'where pin = '"+pinNumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                setVisible(false);
                new Transactions(npin).setVisible(true);


            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);

    }
}
