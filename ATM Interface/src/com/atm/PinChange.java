package com.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {

 
	JPasswordField pin,repin;
	JLabel text, pintext, repintext;
	JButton change,back;
	String pinNumber;

	PinChange(String pinNumber) {
		
		this.pinNumber=pinNumber;
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(0, 0, 720, 720);
		add(Image);

		text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(200, 120, 500, 35);
		Image.add(text);
		
		pintext = new JLabel("NEW PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 15));
		pintext.setBounds(125, 180, 180, 25);
		Image.add(pintext);
		
		pin=new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(280, 180, 130, 20);
		Image.add(pin);
		
		repintext = new JLabel("RE ENTER NEW PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 15));
		repintext.setBounds(125, 220, 180, 25);
		Image.add(repintext);
		
		repin=new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,20));
		repin.setBounds(280, 220, 130, 20);
		Image.add(repin);

		change=new  JButton("CHANGE");
		change.setBounds(260, 340, 150, 30);
		change.addActionListener(this);
		Image.add(change);
		
		back=new  JButton("BACK");
		back.setBounds(260, 375, 150, 30);
		back.addActionListener(this);
		Image.add(back);
		
		
		
		setSize(720, 720);
		setLocation(350, 0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
				
		try {
			String npin=pin.getText();
			String rpin=repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter NEW PIN");
				return;
			}
			
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter NEW PIN");
				return;
			}
			
			Conn conn =new Conn();
			String query1= "Update Bank set pin= '"+rpin+"' where pin='"+pinNumber+"'";
			String query2= "Update Login set pin= '"+rpin+"' where pin='"+pinNumber+"'";
			String query3= "Update SignupThree set pinNumber= '"+rpin+"' where pinNumber='"+pinNumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed sucessfully");
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		}else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

	
}
