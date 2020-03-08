package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		int num=0;
		num=Integer.parseInt(req.getParameter("t1"));
		int cube=(num*num*num);
		pw.println("<br>Second Servlet cube "+cube);
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("success.html");
		rd.include(req,res);
	}//do post
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
				ServletException,IOException{
			
		doPost(req,res);
}//do get
}//class
