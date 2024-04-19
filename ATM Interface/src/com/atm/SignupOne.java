package com.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField, fnameTextField, dobJTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
	JButton next;
	JRadioButton male, female, others, married, unmarried;
	JDateChooser dateChooser;
	
	SignupOne(){
		
		setLayout(null);
		
		Random ran=new Random();
		long random = Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
		getContentPane().setBackground(Color.WHITE);
		formno.setFont(new Font("Raleway",Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personalDetail=new JLabel("Page 1 :Personal Detail");
		personalDetail.setFont(new Font("Raleway",Font.BOLD, 22));
		personalDetail.setBounds(290,80 ,400,30);
		add(personalDetail);
		
		JLabel name=new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD, 20));
		name.setBounds(100,140 ,100,30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel fname=new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD, 20));
		fname.setBounds(100,190 ,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel dob=new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD, 20));
		dob.setBounds(100,240 ,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		add(dateChooser);
	
		JLabel gender=new JLabel("Gender :");
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,290 ,200,30);
		add(gender);
		
		male =new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female =new JRadioButton("Female");
		female.setBounds(470,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		others =new JRadioButton("others");
		others.setBounds(640,290,180,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup  gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email=new JLabel("Email Address :");
		email.setFont(new Font("Raleway",Font.BOLD, 20));
		email.setBounds(100,340 ,200,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel marital=new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway",Font.BOLD, 20));
		marital.setBounds(100,390 ,200,30);
		add(marital);
				
		married =new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried =new JRadioButton("Unmarried");
		unmarried.setBounds(470,390,120,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		others =new JRadioButton("Other");
		others.setBounds(640,390,180,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup  maritalgroup=new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(others);
		
		JLabel address=new JLabel("Address :");
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440 ,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city=new JLabel("City :");
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490 ,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		JLabel state=new JLabel("State :");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540 ,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		JLabel pincode=new JLabel("Pin Code :");
		pincode.setFont(new Font("Raleway",Font.BOLD, 20));
		pincode.setBounds(100,590 ,200,30);
		add(pincode);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
		
	}
	
	
		@Override
	public void actionPerformed(ActionEvent e) {
	String formno= "", random;
	String name = nameTextField.getText();
	String fname = fnameTextField.getText();
	String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
	String gender = null;
	if(male.isSelected()) {
		gender = "Male";
		
	}else if(female.isSelected()) {
		gender ="Female";
	}else if(others.isSelected()) {
		gender ="others";
	}
		String email = emailTextField.getText();
		String marital= null;
		if(married.isSelected()) {
			marital= "Married";
			
		}else if(unmarried.isSelected()) {
			marital= "Unmarried";
		}else if(others.isSelected()) {
			marital= "others";
		}
		
		String address  = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name should not be Empty! ");
			}else {
				Conn c =new Conn();
				String query = "Insert into Signup values('"+formno+"','"+name+"','"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
		}catch(Exception e1){
			System.out.println(e1);
		}
		
		
	}
		
		public static void main(String[] args) {
			new SignupOne();
		}


}
