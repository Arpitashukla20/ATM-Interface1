package com.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pan, aadhar;
	JButton next;
	JDateChooser dateChooser;
	JComboBox religion, category, Occupation, Education, Income,ExistingAccount, SeniorCitizen;
	JRadioButton syes, sno,eyes,eno;
	String formno;
	
	
	SignupTwo(String formno){
		this.formno=formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
				
		JLabel additionalDetail=new JLabel("Page 2 :Additional Detail");
		additionalDetail.setFont(new Font("Raleway",Font.BOLD, 22));
		additionalDetail.setBounds(290,80 ,400,30);
		add(additionalDetail);
		
		JLabel name=new JLabel("Religion :");
		name.setFont(new Font("Raleway",Font.BOLD, 20));
		name.setBounds(100,140 ,100,30);
		add(name);
		
		String valueReligion[]={"Hindu", "Muslim","Sikh", "Christian", "Others" };
		religion =new JComboBox(valueReligion);
		religion.setBounds(300,140 ,400,30);
		religion.setBackground(Color.WHITE);
		add(religion);
				
		
		JLabel fname=new JLabel("Category :");
		fname.setFont(new Font("Raleway",Font.BOLD, 20));
		fname.setBounds(100,190 ,200,30);
		add(fname);
		
		String valueCategory[]= {"General","OBC","SC","ST","others" };
		category = new JComboBox(valueCategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel dob=new JLabel("Income :");
		dob.setFont(new Font("Raleway",Font.BOLD, 20));
		dob.setBounds(100,240 ,200,30);
		add(dob);
		
		String valueIncome[]= {"Null","<1,00,000","<2,00,000","<3,00,000","<4,00,000","<5,00,000","Upto 10,00,000"};
		Income = new JComboBox(valueIncome);
		Income.setBounds(300, 240, 400, 30);
		Income.setBackground(Color.WHITE);
		add(Income);
		
		
	
		JLabel gender=new JLabel("Education");
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,315 ,200,30);
		add(gender);
		JLabel email=new JLabel("Qualification :");
		email.setFont(new Font("Raleway",Font.BOLD, 20));
		email.setBounds(100,340 ,200,30);
		add(email);
		
		String valueEducational[]= {"Non Graduate", "Graduate", "Post Graduate", "Doctrate","others"};
		Education = new JComboBox(valueEducational);
		Education.setBounds(300,340 ,400,30);
		Education.setBackground(Color.WHITE);
		add(Education);
		
		
		JLabel marital=new JLabel("Occupation :");
		marital.setFont(new Font("Raleway",Font.BOLD, 20));
		marital.setBounds(100,390 ,200,30);
		add(marital);
		
		String Occupationvalue[]= {"Salaried", "SelfEmployed", "Bussiness","Student","Retired","Others"};
		Occupation = new JComboBox(Occupationvalue);
		Occupation.setBounds(300,390 ,400,30);
		Occupation.setBackground(Color.WHITE);
		add(Occupation);
						
		
		JLabel address=new JLabel("PAN Number :");
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440 ,200,30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel city=new JLabel("Adhar Number :");
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490 ,200,30);
		add(city);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel state=new JLabel("Senior Citizen :");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540 ,200,30);
		add(state);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup sc=new ButtonGroup();
		sc.add(syes);
		sc.add(sno);
		
		JLabel pincode=new JLabel("Exisiting Account :");
		pincode.setFont(new Font("Raleway",Font.BOLD, 20));
		pincode.setBounds(100,590 ,200,30);
		add(pincode);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup ec=new ButtonGroup();
		ec.add(eyes);
		ec.add(eno);
		
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
	String sreligion =(String) religion.getSelectedItem();
	String scategory =(String) category.getSelectedItem();
	String sIncome = (String) Income.getSelectedItem();
	String sEducation= (String) Education.getSelectedItem();
	String sOccupation=(String) Occupation.getSelectedItem();
	String Seniorcitizen=null;
	if(syes.isSelected()) {
		Seniorcitizen = "Yes";
		
	}else if(sno.isSelected()) {
		Seniorcitizen ="No";
	}
	
		
		String ExistingAccount= null;
		if(eyes.isSelected()) {
			ExistingAccount= "Yes";
			
		}else if(eno.isSelected()) {
			ExistingAccount= "No";
		}
		
		String span  = pan.getText();
		String saadhar = aadhar.getText();
		
		
		try {
				Conn c =new Conn();
				String query = "Insert into SignupTwo values('"+formno+"','"+sreligion+"','"+scategory+"', '"+sIncome+"', '"+sEducation+"', '"+sOccupation+"', '"+span+"',"
						+ "'"+saadhar+"','"+Seniorcitizen+"','"+ExistingAccount+"')";
				c.s.executeUpdate(query);
			
				setVisible(false);
				new SignupThree(formno).setVisible(true);
		}catch(Exception e1){
			System.out.println(e1);}
		}
		
		
	
		
		public static void main(String[] args) {
			new SignupTwo("");
		}


}
