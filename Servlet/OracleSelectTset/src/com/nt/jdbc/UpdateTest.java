package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest{
	public static void main(String[] args) {
	Scanner scn=null;
	Connection con=null;
	Statement st=null;
	String name=null;
	int sno=0;
	String query=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		scn=new Scanner(System.in);
		System.out.println("Enter Student serial number");
		sno=scn.nextInt();
		System.out.println("Enter Student Name");
		name=scn.next();
		String insert_Query=null;
		//update student set sno=1 where name='avnish';
		query="UPDATE STUDENT SET NAME="+"'"+name+"'"+"where sno="+sno;
		System.out.println(query);
		st=con.createStatement();
		int count=st.executeUpdate(query);
		if(count==0) {
			System.out.println("record not updated");
		}
		else {
			System.out.println("record updated");
		}
		
	}
	catch(Exception e) {}
}
}

