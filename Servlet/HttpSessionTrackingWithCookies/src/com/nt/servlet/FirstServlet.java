package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String name=null;
		String address=null;
		int experiance=0;
		name=req.getParameter("name");
		address=req.getParameter("address");
		experiance=Integer.parseInt(req.getParameter("experiance"));
		HttpSession ses=null;
		ses=req.getSession();
		ses.setAttribute("name",name);
		ses.setAttribute("address", address);
		ses.setAttribute("experiance", experiance);
		//creating dynamic form
		/*pw.println("<h1 style='color:blue;text-align:center'>Naukri Form 2</h1");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("ExpectedSal:-<input type='text' name='sal'><br>");
		pw.println("Location:-<input type='text' name='loc'><br>");
		pw.println("<input type='submit' value='continue'>");
		pw.println("</form>");*/
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("ExpectedSal:-<input type='text' name='sal'><br>");
		pw.println("Location:-<input type='text' name='loc'><br>");
		pw.println("<input type='submit' value='continue'>");
		pw.println("</form>");
		System.out.println("after form 1");
		//pw.close();
	}//do post
	@Override
	public void doGet(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		doPost(req,res);
	}//do get
}//class
