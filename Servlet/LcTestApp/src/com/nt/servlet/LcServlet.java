package com.nt.servlet;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
public class LcServlet extends HttpServlet{
	static{
		System.out.println("class loaded");
	}
	 public LcServlet(){
		System.out.println("constructor called");
	}
	public void init(ServletConfig cnfg){
		System.out.println("init method called");
	}
	public void service(ServletRequest req,
							ServletResponse res)throws
								ServletException,IOException{
		System.out.println("service started");
		res.setContentType("text/html");
		PrintWriter pw=null;
		pw=res.getWriter();
		pw.println("Date And Time is"+new Date());
		pw.close();
		
	}
	public void destroy(){
		System.out.println("================================Destroy method called=======================================");
	}
}