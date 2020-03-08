package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstCookie extends HttpServlet {
	public void doPost(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String name=null;
		String fname=null;
		Cookie ck12=null;
		Cookie ck21=null;
		//accesing form data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		//creating cookies
		ck12=new Cookie("name1",name);
		ck21=new Cookie("fname1",fname);
		//adding cookies to the response obj
		res.addCookie(ck12);
		res.addCookie(ck21);
		//pw.println("<h1 style='color:red;text-align:center'>"+"Form 1 Data.."+name+".."+fname);
		//creating dynamic form
		pw.println("<h1 style='color:red;text-align:center'>form 2 Details</h1>");
		pw.println("<form action='secondurl' method='Post'>");
		pw.println("Income:-<input type='text' name='income'/>");
		pw.println("Tax:-<input type='text' name='tax'/>");
		pw.println("<input type='submit' value='submit'/>");
		pw.close();
	}//dopost

	public void doGet(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		doPost(req,res);
	}//doget

}//class
