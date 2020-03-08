package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest{
	public static void main(String[] args) {
		Scanner scn=null;
		ResultSet rs=null;
		Statement st=null;
		Connection con=null;
		String course1=null,course2=null,course3=null;
		String cond=null;
		String query=null;
		try{
			scn=new Scanner(System.in);
			System.out.println("Enter first course");
			course1=scn.nextLine();
			System.out.println("Enter second course");
			course2=scn.nextLine();
			System.out.println("Enter third course");
			course3=scn.nextLine();
			cond="('"+course1+"','"+course2+"','"+course3+"')";
		    query="SELECT *FROM TEST1 WHERE COURSE IN "+cond+"";
		    System.out.println(query);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","system","tiger");
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				
			}//while close
		}//try close 
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) 
					con.close();	
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
			try {
				if(rs!=null)
				rs.close();
			}
				catch(SQLException n) {
					n.printStackTrace();
				}
			try {
				if(st!=null)
					st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}//finally close
		
		}//main close
	}//class close

