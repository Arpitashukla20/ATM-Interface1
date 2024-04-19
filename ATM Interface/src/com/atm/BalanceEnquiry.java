package com.atm;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
		JButton back;
		String pinNumber;

		BalanceEnquiry(String pinNumber){
			
			this.pinNumber=pinNumber;
			
			setLayout(null);

			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
			Image i2 = i1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel Image = new JLabel(i3);
			Image.setBounds(0, 0, 720, 720);
			add(Image);
			

			back=new  JButton("BACK");
			back.setBounds(260, 375, 150, 30);
			back.addActionListener(this);
			Image.add(back);
			
			Conn conn=new Conn();
			int balance=0;
			try {
				ResultSet rs=conn.s.executeQuery("Select * from Bank where pin='"+pinNumber+"'");
			
				while(rs.next()) {
					if (rs.getString("Type").equals("Deposit")){
						balance+=Integer.parseInt(rs.getString("amount"));
						
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
			}catch(Exception ex) {
					System.out.println(ex);
				}
			
			
			JLabel text=new JLabel("Your Current Account balance is Rs"+balance);
			text.setForeground(Color.WHITE);
			text.setBounds(130, 130, 300, 25);
			Image.add(text);
			
			
			setSize(720, 720);
			setLocation(350, 0);
			setUndecorated(true);
			setVisible(true);
		}
		
	


	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
