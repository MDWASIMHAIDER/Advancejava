package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest1 {

	public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	Scanner scn=null;
	String city1=null;
	String city2=null;
	String query=null;
	int res=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			scn=new Scanner(System.in);
			System.out.println("Enter city 1 name");
			city1=scn.next();
			System.out.println("Enter city 2 name");
			city2=scn.next();
			query="DELETE FROM STUDENT WHERE CITY="+"'"+city1+"'"+" or "+"city=" +"'"+city2+"'";
			System.out.println(query);
			st=con.createStatement();
		    res=st.executeUpdate(query);
			System.out.println("after query");
			if(res==0) {
				System.out.println("not deleted");
			}
			else {
				System.out.println("deleted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
