package com.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
	
	JButton deposit, withdrawl,ministatement, pinchange, fastcash, balanceenquery,exit;
	String pinNumber;
	
	FastCash(String pinNumber)
	{
		this.pinNumber=pinNumber;
		
		
		setLayout(null);
		
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 =i1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel Image =new JLabel(i3);
		Image.setBounds(0, 0, 720, 720);
		add(Image);
		
		JLabel text =new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(150,150,700,25);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		Image.add(text);
		
		
		deposit=new JButton("RS 100");
		deposit.setBounds(130,225,130,30);
		deposit.addActionListener(this);
		Image.add(deposit);
		
		withdrawl=new JButton("RS 500");
		withdrawl.setBounds(275,225,130,30);
		withdrawl.addActionListener(this);
		Image.add(withdrawl);
		
		ministatement=new JButton("RS 1000");
		ministatement.setBounds(275,260,130,30);
		ministatement.addActionListener(this);
		Image.add(ministatement);
		
		fastcash=new JButton("RS 2000");
		fastcash.setBounds(130,260,130,30);
		fastcash.addActionListener(this);
		Image.add(fastcash);

		pinchange=new JButton("RS 5000");
		pinchange.setBounds(130,295,130,30);
		pinchange.addActionListener(this);
		Image.add(pinchange);
		
		balanceenquery=new JButton("RS 10000");
		balanceenquery.setBounds(275,295,130,30);
		balanceenquery.addActionListener(this);
		Image.add(balanceenquery);

		exit=new JButton("BACK");
		exit.setBounds(200,330,130,30);
		exit.addActionListener(this);
		Image.add(exit);
		
		setSize(720, 720);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}else {
			String amount=((JButton)e.getSource()).getText().substring(3);
			Conn conn=new Conn();
			try {
				ResultSet rs=conn.s.executeQuery("Select * from Bank where pin='"+pinNumber+"'");
				int balance=0;
				while(rs.next()) {
					if (rs.getString("Type").equals("Deposit")){
						balance+=Integer.parseInt(rs.getString("amount"));
						
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
				if(e.getSource()!= exit && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date=new Date();
				String query="Insert into Bank values('"+pinNumber+"', '"+date+"','"+withdrawl+"', '"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Sucessfully ");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
	}
	public static void main(String[] args) {
		new FastCash("");
	}
	
}
