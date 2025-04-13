package  bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,  pincodeTextField, mobilenoTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser datechooser;
    private String generateOTP() {
        Random rand = new Random();
        int otpValue = 100000 + rand.nextInt(900000);
        return String.valueOf(otpValue);
    }
    SignupOne(){

        setLayout(null);
        Random ran=new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
//header
        JLabel formno=new JLabel("APPLICATION FORM NO." +  random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
//header
        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
//name
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
//textfield
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
//father name
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
//textfield
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
//dob
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
//datechooser
        datechooser  = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);

//gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
//radio button
        male  = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female  = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup  = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
//email
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
//textfield
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
//marital status
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
//radio button
        married  = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried  = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other  = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalgroup  = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
//address
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
//textfield
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
//city
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
//textfield
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
//state
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
//textfield
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
//pincode
        JLabel pincode =new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
//textfield
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        //mobile
        JLabel mobileno=new JLabel("Mobile no.:");
        mobileno.setFont(new Font("Raleway", Font.BOLD, 20));
        mobileno.setBounds(100,640,200,30);
        add(mobileno);
//textfield
        mobilenoTextField = new JTextField();
        mobilenoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mobilenoTextField.setBounds(300,640,400,30);
        add(mobilenoTextField);
//next button
        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

//background
        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno=""+random;  //long to string
        String name = nameTextField.getText();  //setText
        String fname =fnameTextField.getText();
        String dob =((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";
        }

        String email =emailTextField.getText();
        String marital=null;
        if (married.isSelected()){
            marital="Married";
        } else if (unmarried.isSelected()) {
            marital="Unmarried";
        } else if (other.isSelected()) {
            marital="Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        String mobileno = mobilenoTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if (mobileno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mobile number is required.");
            }
            else {
                Conn c = new Conn();
                String query ="insert into signup values(' "+formno+" ', ' "+name+" ',' "+fname+" ',' "+dob+" ',' "+gender+" ',' "+email+" ',' "+marital+" ',' "+address+" ',' "+city+" ',' "+pincode+" ',' "+state+" ',' "+mobileno+" ')";
                c.s.executeUpdate(query);
                new Signuptwo(formno).setVisible(true);
                setVisible(false);
                    }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
