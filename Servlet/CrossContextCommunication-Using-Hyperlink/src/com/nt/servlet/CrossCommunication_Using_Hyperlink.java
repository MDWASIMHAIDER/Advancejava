package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hyperurl")
public class CrossCommunication_Using_Hyperlink extends HttpServlet {
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		String value=null;
		value=req.getParameter("search");
		//String link="https://www.google.com/search?source="+value;
		pw.println(value);
		pw.println("<a href='https://www.google.com/search?q=" +value+"'>google.com</h1>");
	}
}
