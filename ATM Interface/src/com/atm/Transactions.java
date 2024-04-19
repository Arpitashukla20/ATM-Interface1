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

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit, withdrawl,ministatement, pinchange, fastcash, balanceenquiry,exit;
	String pinNumber;
	
	Transactions(String pinNumber)
	{
		this.pinNumber=pinNumber;
		
		
		setLayout(null);
		
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 =i1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel Image =new JLabel(i3);
		Image.setBounds(0, 0, 720, 720);
		add(Image);
		
		JLabel text =new JLabel("Please select your Transaction");
		text.setBounds(150,150,700,25);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		Image.add(text);
		
		
		deposit=new JButton("Deposit");
		deposit.setBounds(130,225,130,30);
		deposit.addActionListener(this);
		Image.add(deposit);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setBounds(275,225,130,30);
		withdrawl.addActionListener(this);
		Image.add(withdrawl);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(275,260,130,30);
		ministatement.addActionListener(this);
		Image.add(ministatement);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBounds(130,260,130,30);
		fastcash.addActionListener(this);
		Image.add(fastcash);

		pinchange=new JButton("Pin Change");
		pinchange.setBounds(130,295,130,30);
		pinchange.addActionListener(this);
		Image.add(pinchange);
		
		balanceenquiry=new JButton("Balance Enquiry");
		balanceenquiry.setBounds(275,295,130,30);
		balanceenquiry.addActionListener(this);
		Image.add(balanceenquiry);

		exit=new JButton("Exit");
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
			System.exit(0);
		}else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(e.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}else if(e.getSource()==fastcash){		
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(e.getSource()==pinchange){		
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}else if(e.getSource()==balanceenquiry){		
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}else if(e.getSource()==ministatement){		
			new MiniStatement(pinNumber).setVisible(true);
		}
		}
	public static void main(String[] args) {
		new Transactions("");
	}
	
}
