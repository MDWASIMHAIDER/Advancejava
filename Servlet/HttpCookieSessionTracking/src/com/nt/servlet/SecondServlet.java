package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,
						 HttpServletResponse res) throws
							ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String name=null;
		String fname=null;
		Connection con=null;
		Statement st=null;
		int result=0;
		PreparedStatement ps=null;
		Cookie[] ck1=req.getCookies();
		float income=Float.parseFloat(req.getParameter("income"));
		float tax=Float.parseFloat(req.getParameter("tax"));
		if(ck1!=null) {
			name=ck1[0].getValue();
			fname=ck1[1].getValue();
		}//if
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			st=con.createStatement();
			ps=con.prepareStatement("INSERT INTO STUDENT1 VALUES(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2, fname);
			ps.setFloat(3, income);
			ps.setFloat(4, tax);
			result=ps.executeUpdate();
			if(result==1) {
				pw.println("Record Inserted Successfully<br>");
			}
			else {
				pw.println("Record not inserted<br>");
			}
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
		}
		pw.println("<br>form 1 data  "+name+".."+fname);
		pw.println("form 2 data  "+income+",,"+tax);
		pw.close();
	}//do post
	
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws 
							ServletException,IOException{
		doPost(req,res);
	}
	
}//class
