package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrageServletValidation extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)
							throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=null;
		pw=res.getWriter();
		String name=null;
		String age=null;
		String gender=null;
		int tage=0;
		name=req.getParameter("pname");//reading data from html form
		age=req.getParameter("page");//reading data from html form
		gender=req.getParameter("gender");//reading data from html form
		String jstatus=req.getParameter("hiddenbox");
		try {
	      tage=Integer.parseInt(age);
		}catch(NumberFormatException e) {}
		//System.out.println(gender);
		//System.out.println(name);
		//System.out.println(tage);
		if(jstatus.equalsIgnoreCase("no")) {
		   if(name=="" || name.length()==0 || name.equals("")) {
			   pw.println("<h1>name is mandatory</h1>");
			   return;
		   }
		   if(age==""){
			   pw.println("<h1>Age is mandatory</h1>");
			   return;
		   }
		}
		if(gender.equalsIgnoreCase("male")) {
			if(tage>=18){
				pw.println("<h1>"+name+" You are eligible for marrage</h1>");
			}
			else {
				pw.println("<h1>"+name+" You are not eligible for marrage</h1>");
			}
		}//male if
		if(gender.equalsIgnoreCase("female")) {
			if(tage>=18) {
				pw.println("<h1>"+name+"  Miss You are eligible for marrage</h1>");
			}
			else {
				pw.println("<h1>"+name+"  Miss You are not eligible for marrage</h1>");
			}
		}//female if
		pw.println("<a href='home.html'>Home</a>");
	}//doGet closing
	@Override
	public void doPost(HttpServletRequest req,
							HttpServletResponse res)
								throws ServletException,IOException{
		doGet(req,res);
	}

}//class closing
