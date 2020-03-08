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
public class SecondCookie extends HttpServlet {
	protected void doPost(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		float income=Float.parseFloat(req.getParameter("income"));
		float tax=Float.parseFloat(req.getParameter("tax"));
		Cookie[] ck1=null;
		String name12=null;
		String fname12=null;
		String INSERT_QUERY=null;
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		int result=0;	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			ck1=req.getCookies();
			if(ck1!=null) {
				name12=ck1[0].getValue();
				fname12=ck1[1].getValue();
			}//if
			INSERT_QUERY="INSERT INTO STUDENT1 VALUES("+"'"+name12+"',"+"'"+fname12+"','"+income+"','"+tax+"')";
			
			//st=con.createStatement();
			ps=con.prepareStatement("INSERT INTO STUDENT1 VALUES(?,?,?,?)");
			ps.setString(1,name12);
			ps.setString(2, fname12);
			ps.setFloat(3, income);
			ps.setFloat(4, tax);
			result=ps.executeUpdate();
		}//try
		catch(SQLException s) {
			s.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(SQLException s) {
					s.printStackTrace();
				}
				try {
					if(st!=null) {
						st.close();
					}
				}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
		pw.println("<h1 style='color:red;text-align:center'>"+"Form 1 Data.."+name12+".."+fname12+"<br>");
		pw.println("<h1 style='color:red;text-align:center'>"+"Form 2 Data.."+income+".."+tax+"<br>");
		System.out.println(INSERT_QUERY);
		if(result==1) {
			pw.println("<h1 style='color:red;text-align:center'>Record Inserted</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Record Not Inserted</h1>");
		}
	}//dopost
	public void doGet(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		doPost(req,res);
	}
}//class
