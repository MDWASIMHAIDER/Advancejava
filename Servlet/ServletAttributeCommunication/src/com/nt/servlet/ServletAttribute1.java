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
import javax.servlet.http.HttpSession;
@WebServlet("/firsturl")
public class ServletAttribute1 extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		HttpSession ss=null;
		ServletContext sc=null;
		RequestDispatcher rd=null;
		//create request attribute
		req.setAttribute("RequestAttribute1", "wasim");
	    ss=req.getSession();
	    ss.setAttribute("SessionAttribute2","bhagwati");
	    sc=getServletContext();
	    sc.setAttribute("contextAttribute3","abhishek");
	    rd=req.getRequestDispatcher("secondurl");
	    rd.forward(req, res);
	}//do post
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
				ServletException,IOException{

		doPost(req,res);
}//do get
}//class
