package com.nt.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchurl")
public class SearchCommunicationServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		int  ename=0;
		ResultSet rs=null;
		RequestDispatcher rd1=null,rd2=null;
	try{
		rd1=req.getRequestDispatcher("/headerurl");
		rd1.include(req,res);
		ename=Integer.parseInt(req.getParameter("ename1"));
		pw=res.getWriter();
		res.setContentType("text/html");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
			ps=con.prepareStatement("SELECT *FROM TEST1 WHERE SEQ_NO=?");
			ps.setInt(1,ename);
			rs=ps.executeQuery();
			while(rs.next()!=false) {
				pw.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req,res);
			ps.close();
			rs.close();
			con.close();
		}catch(Exception e) {
			System.out.println("catch");
			RequestDispatcher rd=req.getRequestDispatcher("/errorurl");
			rd.forward(req, res);
			
		}
	
	}//do get
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doPost(req,res);
	}//do get
}//class
