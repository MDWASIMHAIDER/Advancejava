package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		
		res.setContentType("text/html");
		PrintWriter pw=null;
		pw=res.getWriter();
		String name=null;
		int age=0;
		String gender=null;
		String add=null;
		String mstatus=null;
		String qualify=null;
		String course[]=null;
		String hobby[]=null;
		name=req.getParameter("Pname");
		System.out.println(name);
		age=Integer.parseInt(req.getParameter("Page"));
		gender=req.getParameter("gender");
		add=req.getParameter("tadd");
		mstatus=req.getParameter("ms");
		qualify=req.getParameter("qualify");
		course=req.getParameterValues("crs");
		hobby=req.getParameterValues("hb");
		if(gender.equalsIgnoreCase("female")) {
		if(age<=5){
			pw.println("<h1>"+name+"You are baby girl</h1> ");
		}
		else if(age<=12) {
			pw.println("<h1>"+name+"You are small girl</h1> ");
		}
		else if(age<=19) {
			pw.println("<h1>"+name+"You are baby girl</h1> ");
		}
		else if(age<=35) {
			pw.println("<h1>"+name+"You are young girl</h1> ");
		}
		else if(age<=50) {
			pw.println("<h1>"+name+"You are middle age woman</h1> ");
		}
		else {
			pw.println("<h1>"+name+"you are buddhi</h1>");
		}
		
	}
		if(gender.equalsIgnoreCase("male")) {
			if(age<=5){
				pw.println("<h1>"+name+"You are baby boy</h1> ");
			}
			else if(age<=12) {
				pw.println("<h1>"+name+"You are small boy</h1> ");
			}
			else if(age<=19) {
				pw.println("<h1>"+name+"You are teenage boy</h1> ");
			}
			else if(age<=35) {
				pw.println("<h1>"+name+"You are young young</h1> ");
			}
			else if(age<=50) {
				pw.println("<h1>"+name+"You are middle age man</h1> ");
			}
			else {
				pw.println("<h1>"+name+"you are buddha</h1>");
			}
			
		}
		
		pw.println("<h1> name:"+name+"</h1>");
		pw.println("<h1> age:"+age+"</h1>");
		pw.println("<h1> gender:"+gender+"</h1>");
		pw.println("<h1> Address:"+add+"</h1>");
		pw.println("<h1> MarryStatus:"+mstatus+"</h1>");
		pw.println("<h1> qualification:"+qualify+"</h1>");
		pw.println("<h1> course:"+Arrays.toString(course)+"</h1>");
		pw.println("<h1> hobby:"+Arrays.toString(hobby)+"</h1>");
		pw.close();
		
	}
	@Override
	public void doPost(HttpServletRequest req,
							HttpServletResponse res)throws
								ServletException,IOException{
		doGet(req,res);
		
	}

}
