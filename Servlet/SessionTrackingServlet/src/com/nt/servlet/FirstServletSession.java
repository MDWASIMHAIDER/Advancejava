package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registerurl")
public class FirstServletSession extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String fname=null;
		String name=null;
		String ms=null;
		fname=req.getParameter("fname");
		name=req.getParameter("name");
		ms=req.getParameter("ms");
		if(ms.equalsIgnoreCase("single")) {
			pw.println("<form action='surl' method='POST'>");
			pw.println("Why do you want to marry<input type='text' name='f2t1'><br>");
			pw.println("When do you want to marry<input type='text' name='f2t2'><br>");
			//add form1 req1 data to dnamic form page as hidden box vlaue
			pw.println("<input type='hidden' name='hname' value="+name+"><br>");
			pw.println("<input type='hidden' name='hfname' value="+fname+"><br>");
			pw.println("<input type='hidden' name='hms' value="+ms+"><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//if
		else {
			pw.println("<form action='surl' method='POST'>");
			pw.println("Spouse Name<input type='text' name='f2t1'><br>");
			pw.println("No Of Children<input type='text' name='f2t2'><br>");
			//add form1 req1 data to dnamic form page as hidden box vlaue
			pw.println("<input type='hidden' name='hname' value="+name+"><br>");
			pw.println("<input type='hidden' name='hfname' value="+fname+"><br>");
			pw.println("<input type='hidden' name='hms' value="+ms+"><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");	
		}
		pw.close();
	}//do post
	public void dGet(HttpServletRequest req,
			HttpServletResponse res)throws
				ServletException,IOException{
		doPost(req,res);
    }//do get
}//class
