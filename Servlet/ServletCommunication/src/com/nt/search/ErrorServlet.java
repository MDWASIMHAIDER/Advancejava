package com.nt.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/errorurl")
public class ErrorServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("error.html");
		rd.forward(req,res);
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center'>Internal Error</h1>");
		pw.println("<a href='search.html'>Home</a>");
		pw.close();
	}
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doPost(req,res);
	}

}
