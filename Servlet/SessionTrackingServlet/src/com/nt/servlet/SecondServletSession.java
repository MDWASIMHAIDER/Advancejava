package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/surl")
public class SecondServletSession extends HttpServlet{
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String ms=req.getParameter("hms");
		String t1val=req.getParameter("f2t1");
		int t2val=Integer.parseInt(req.getParameter("f2t2"));
		String query=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			//insert into bachelors values('wasim','shahid','single','make life complete',2)
			PreparedStatement ps=con.prepareStatement("INSERT INTO BACHELORS VALUES(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4, t1val);
			ps.setInt(5,t2val);
			Statement st=con.createStatement();
			//query="INSERT INTO BACHELORS VALUES("+name+","+fname+","+ms+","+t1val+","+t2val+")";
			int result=ps.executeUpdate();
			if(result==0) {
			pw.println("Record Not Inserted");
			}
			else {
				pw.println("Record Inserted");
			}
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<br>form 1 data is:"+name+" "+fname+" "+ms+" ");
		pw.println("<br>form 2 data is:"+t1val+" "+t2val+" ");
		
	}//do post
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
				ServletException,IOException{
			doPost(req,res);
}
}
