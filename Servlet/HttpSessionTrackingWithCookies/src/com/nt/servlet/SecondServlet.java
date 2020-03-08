package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		System.out.println("second sevlet");
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		int salary=0;
		String location=null;
		salary=Integer.parseInt(req.getParameter("sal"));
		location=req.getParameter("loc");
		HttpSession ses1=null;
		ses1=req.getSession();
		ses1.setAttribute("salary",salary);
		ses1.setAttribute("location", location);
		/*pw.println("<h1 style='color:blue;text-align:center'>Naukri Form 2</h1");
		pw.println("<form action='thirdurl' method='POST' style='text-align:center'>");
		pw.println("Age:-<input type='text' name='age'/><br>");
		pw.println("Skill:-<input type='text' name='skill'/><br>");
		pw.println("<input type='submit' value='continue'/>");
		pw.println("</form>");*/
		//pw.println("<h1 style='color:blue;text-align:center'>Naukri Form 2</h1");
		pw.println("<form action='thirdurl' method='POST'>");
		pw.println("Age:-<input type='text' name='age'><br>");
		pw.println("Skill:-<input type='text' name='skill'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		System.out.println("second after form");
	}//do post

	@Override
	protected void doGet(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		
		doPost(req, res);
	}//do get
	
}//class
