package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcesServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
							throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=null;
		pw=res.getWriter();
		int num1=0;
		int num2=0;
		String n=req.getParameter("v1");
		String n2=req.getParameter("v2");
		num1=Integer.parseInt(n);
		num2=Integer.parseInt(n2);
		String lnk=null;
		lnk=req.getParameter("s1");
		System.out.println(lnk);
		System.out.println(num1);
		if(lnk.equalsIgnoreCase("add")) {
			pw.println(num1+num2);
		}
		if(lnk.equalsIgnoreCase("sub")) {
			pw.println(num1-num2);
		}
		if(lnk.equalsIgnoreCase("mul")) {
			pw.println(num1*num2);
		}
		pw.close();
	}//doGet closing
	@Override
	public void doPost(HttpServletRequest req,
							HttpServletResponse res)throws
									ServletException,IOException{
		doGet(req,res);
	}
}//class closing
