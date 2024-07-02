import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class signUpTwo extends JFrame implements ActionListener{
    String formno;
    JTextField cityTextField,addressTextField;
    JButton next;
    JRadioButton yes,no,yesAccount,noAccount;
    JComboBox religion,category,income,qualification,occupation;
    signUpTwo(String formno){
        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String [] arrReligion = {"Hindu","Sikh","Christian","Other"};
        religion = new JComboBox(arrReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fName = new JLabel("Category:");
        fName.setFont(new Font("Raleway",Font.BOLD,20));
        fName.setBounds(100,190,200,30);
        add(fName);

        String [] arrCategory = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(arrCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String [] arrIncome = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(arrIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);


        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String [] arrQualification = {"Non Graduate","Under Graduate","Graduate","Post Graduate","Doctrate"};
        qualification = new JComboBox(arrQualification);
        qualification.setBounds(300,315,400,30);
        qualification.setBackground(Color.white);
        add(qualification);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String [] arrOccupation = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(arrOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,15));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        yes = new JRadioButton("Yes");
        yes.setBounds(300,540,200,30);
        yes.setBackground(Color.white);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(500,540,200,30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup gp = new ButtonGroup();
        gp.add(yes);
        gp.add(no);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        yesAccount = new JRadioButton("Yes");
        yesAccount.setBounds(300,590,200,30);
        yesAccount.setBackground(Color.white);
        add(yesAccount);

        noAccount = new JRadioButton("No");
        noAccount.setBounds(500,590,200,30);
        noAccount.setBackground(Color.white);
        add(noAccount);

        ButtonGroup gpAccount = new ButtonGroup();
        gpAccount.add(yesAccount);
        gpAccount.add(noAccount);

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
        String ansReligion = (String)religion.getSelectedItem();
        String ansCategory = (String)category.getSelectedItem();
        String ansIncome = (String)income.getSelectedItem();
        String ansQualification = (String)qualification.getSelectedItem();
        String ansOccupation = (String)occupation.getSelectedItem();
        String seniorCitizen = null;
        if(yes.isSelected()){
            seniorCitizen = "Yes";
        } else if (no.isSelected()) {
            seniorCitizen = "No";
        }
        String alreadyExist = null;
        if(yesAccount.isSelected()){
            alreadyExist = "Yes";
        }else if(noAccount.isSelected()){
            alreadyExist = "No";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        try{

            conn c = new conn();
            String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+ansReligion+"','"+ansCategory+"','"+ansIncome+"','"+ansQualification+"','"+ansOccupation+"','"+address+"','"+city+"','"+seniorCitizen+"','"+alreadyExist+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signUpThree(formno).setVisible(true);


        }catch(Exception e){
            System.out.println("Exception is"+e);
        }
    }

    public static void main(String[] args) {
        new signUpTwo("");
    }
}