package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.faces.application.ResourceDependencies;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/poolurl")
public class WeblogicDataSourseServlet extends HttpServlet{
	@Resource(name="Dsjndi")
	DataSource ds=null;
	Connection con=null;
	String INSERT_STUDENT_QUERY="insert into test1 values(?,?,?,seq_no.nextval)";
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		String sName=req.getParameter("sno");
		String sAdd=req.getParameter("address");
		String sCourse=req.getParameter("course");
		try {
			con=ds.getConnection();
			System.out.println("con obj");
			//con=getPooledConnection();
			ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		ps.setString(1,sName);
		ps.setString(2,sAdd);
		ps.setString(3,sCourse);
		result=ps.executeUpdate();
		if(result==0) {
			pw.println("<h1>Resgistration failed</h1>");
		}
		else {
			pw.println("<h1>Resgistration Successful</h1>");
		}
		pw.println("<a href='input.html'>Resgistration failed</a>");
		pw.close();
		}//try close
		catch(SQLException e) {e.printStackTrace();System.out.println("sql");}
		catch(Exception e) {e.printStackTrace();System.out.println("exception");}
	}//doget close
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
			doGet(req,res);
		
	}//do post close
	/*private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		//Connection con=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("Dsjndi");
		con=ds.getConnection();
		return con;
		
	}*/
}//class close
