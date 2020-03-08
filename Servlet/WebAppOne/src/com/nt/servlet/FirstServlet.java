package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		int num=0;
		int square=0;
		num=Integer.parseInt(req.getParameter("t1"));
		square=(num*num);
		pw.println("<br>FirstServlet square "+square);
		RequestDispatcher rd=null;
		ServletContext sc1=getServletContext();
		ServletContext sc2=sc1.getContext("/WebAppTwo");
		rd=sc2.getRequestDispatcher("/secondurl");
		rd.include(req, res);
		pw.close();
	}//dopost
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doPost(req,res);
	}
	
}