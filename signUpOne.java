import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class signUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fNameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinCodeTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;

    signUpOne(){

        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,15));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway",Font.BOLD,20));
        fName.setBounds(100,190,200,30);
        add(fName);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Arial",Font.BOLD,15));
        fNameTextField.setBounds(300,190,400,30);
        add(fNameTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Others");
        other.setBounds(620,290,120,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup genderGrp = new ButtonGroup();
        genderGrp.add(male);
        genderGrp.add(female);
        genderGrp.add(other);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,15));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup maritalGrp = new ButtonGroup();
        maritalGrp.add(married);
        maritalGrp.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,15));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial",Font.BOLD,15));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Arial",Font.BOLD,15));
        pinCodeTextField.setBounds(300,590,400,30);
        add(pinCodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }else if(other.isSelected()){
            gender = "Other";
        }
        String email = emailTextField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        }else if(unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinCodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c = new conn();
                String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signUpTwo(formno).setVisible(true);

            }
        }catch(Exception e){
            System.out.println("Exception is"+e);
        }
    }

    public static void main(String[] args) {
        new signUpOne();
    }
}
