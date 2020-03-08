package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/secondurl")
public class ServletAttribute2 extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		
		PrintWriter pw=null;
		res.setContentType("text/html");
		RequestDispatcher rd=null;
		pw=res.getWriter();
		HttpSession ss=null;
		ServletContext sc=null;
		pw.println("Sevlet2:-Atribute1 value-->"+req.getAttribute("RequestAttribute1"));
		ss=req.getSession();
		pw.println("Sevlet2:-SessionAttribute1 value-->"+ss.getAttribute("SessionAttribute2"));
		sc=req.getServletContext();
		pw.println("Sevlet2:-ServletAttribute1 value-->"+sc.getAttribute("contextAttribute3"));
		rd=req.getRequestDispatcher("thirdurl");
		rd.forward(req, res);
	}//do post
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
				ServletException,IOException{
		doPost(req,res);
}//do get

}//class
