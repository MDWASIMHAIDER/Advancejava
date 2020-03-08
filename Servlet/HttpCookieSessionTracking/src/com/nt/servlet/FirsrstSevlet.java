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
public class FirsrstSevlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		Cookie ck1=null;
		Cookie ck2=null;
		String name=null,fname=null;
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		ck1=new Cookie("name",name);
		ck2=new Cookie("fame",fname);
		res.addCookie(ck1);
		res.addCookie(ck2);
		//now we haave to generate form2 dynamically
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("Income:-<input type='text' name='income'><br>");
		pw.println("Tax:-<input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		pw.close();
		
		
	}//do post

	protected void doGet(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		doPost(req,res);
	}
}//class
