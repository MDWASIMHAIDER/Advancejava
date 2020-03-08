package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAuthenticationTest {
	
	public static void main(String[] args)throws Exception {
		Connection con=null;
		Statement st=null;
		Scanner scn=null;
		String uname=null;
		String password=null;
		int count=0;
		//PreparedStatement pd=null;
		ResultSet rs=null;
		scn=new Scanner(System.in);
		System.out.println("Enter username");
		uname=scn.next();
		System.out.println("Enter password");
		password=scn.next();
		String QUERY="SELECT COUNT(*) FROM USER_INFO WHERE USERNAME="+"'"+uname+"' AND "+"password='"+password+"'"; 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		st=con.createStatement();
		rs=st.executeQuery(QUERY);
		if(st!=null) {
			while(rs.next()) {
				count=rs.getInt(1);
			}
		}
		if(count==0) {
			System.out.println("Invalid Credentials");
		}
		else {
			System.out.println("Valid Credentials");
		}
		if(con!=null) {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//main
}//class
