package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
							HttpServletResponse res)
									throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=null;
		String name=null;
		pw=res.getWriter();
		name=req.getParameter("country");
		System.out.println(name);
		if(name.equalsIgnoreCase("india")){
			pw.println("<h1>Capital of "+name+"is New Delhi</h1>");
		}
		else if(name.equalsIgnoreCase("aus")){
			pw.println("<h1>Capital of "+name+"is malebourn</h1>");
		}
		else if(name.equalsIgnoreCase("indo")){
			pw.println("<h1>Capital of "+name+"is Indonesia</h1>");
		}
		pw.println("<br><a href='country.html'>Home</a>");
		
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req,
							HttpServletResponse res)throws
									ServletException,IOException{
		doGet(req,res);
	}

}
