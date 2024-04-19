package com.atm;

import java.sql.*;

public class Conn {
	/*
	 * FOR CONNECTING PROJECT WITH DATA BASE WE USE 5 STEPS 1>> REGISTER THE DRIVER
	 * 2>> CREATE CONNECTION 3>> CREATE STATEMENT 4>> EXECUTE QUERY 5>> CLOSE
	 * CONNECTION
	 */
	Connection c;
	Statement s;
	public Conn() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3307/ATM_Interface", "root", "MYSQL@12");
			s=c.createStatement();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}