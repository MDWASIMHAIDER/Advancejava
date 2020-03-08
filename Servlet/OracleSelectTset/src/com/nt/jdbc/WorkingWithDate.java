package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class WorkingWithDate {
	/*create table working_with_date(applicant_name varchar2(15),
	 *        age number(3),dob date,doj date,dom date);
	 *        create sequence id_applicant start with 1 increment by 1;*/
	private static final String INSERT_DATE_QUERY="INSERT INTO WORKING_WITH_DATE VALUES(?,?,?,?,?,id_applicant.nextval)";
	
	public static void main(String[] args) {
		PreparedStatement ps=null;
		Connection con=null;
		Scanner sc=null;
		try {
			
			String name=null,doj=null,dom=null,dob=null;
			int age=0;
			long ms=0,ms1=0,ms2=0;
			int result=0;
			SimpleDateFormat sdf=null;
			java.util.Date udob=null,udom=null,udoj=null;
			java.sql.Date sqdob=null,sqdoj=null,sqdom=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Applicant Name");
				name=sc.nextLine();
				System.out.println("Enter Age");
				age=sc.nextInt();
				System.out.println("Enter Date of Birth(dd-MM-yyyy)");
				dob=sc.nextLine();
				dob=sc.nextLine();
				System.out.println("Enter Date of Joining(yyyy-MM-dd)");
				doj=sc.nextLine();
				System.out.println("Enter Date of Marrage(yyyy-MM-dd)");
				dom=sc.nextLine();
			}//if
			//convert String date value to java.sql.date class obj
			sdf=new SimpleDateFormat("dd-MM-yyyy");
			if(sdf!=null)
				udob=sdf.parse(dob);
				if(udob!=null) {
					ms=udob.getTime();
					sqdob=new java.sql.Date(ms);//gives java.sql.date class obj 
					
					//for doj
					//sqdoj=java.sql.Date.valueOf(udoj);
					if(sdf!=null)
						udoj=sdf.parse(doj);
						if(udoj!=null)
							ms1=udoj.getTime();
							sqdoj=new java.sql.Date(ms1);
					
					//sqdom=java.sql.Date.valueOf(udom);//for dom method 1
					if(sdf!=null)//method 2
						udom=sdf.parse(dom);
						if(udom!=null)
							ms2=udom.getTime();
							sqdom=new java.sql.Date(ms2);
						
						
			}
				if(con!=null) {
					ps=con.prepareStatement(INSERT_DATE_QUERY);
					ps.setString(1, name);
					ps.setInt(2,age);
					ps.setDate(3,sqdob);
					ps.setDate(4,sqdoj);
					ps.setDate(5, sqdom);
				}
				//execute query
				if(ps!=null) {
					result=ps.executeUpdate();
				}
				if(result==0)
					System.out.println("record not inserted");
					else 
						System.out.println("record inserted");
					
				
					
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(sc!=null)
				sc.close();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


