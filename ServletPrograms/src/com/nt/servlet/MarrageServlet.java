package com.nt.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MarrageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=null;
		String name=null;
		String age=null;
		String gender=null;
		int rage=0;
		pw=res.getWriter();
		name=req.getParameter("pname");
		System.out.println(name);
		age=req.getParameter("page");
		rage=Integer.parseInt(age);
		System.out.println(rage);
		gender=req.getParameter("pgender");
		System.out.println(gender);
		if(rage!=0 && name.length()>=4){
		if(rage<=17 && gender.equals("male")){
			pw.println("<h1 style='color:red'>"+name+"You are not eligible for marrage</h1>");
		}
		else if(rage<=17 && gender.equals("female")){
			pw.println("<h1 style='color:red'>Gender=="+gender+"--->"+name+"--You are not eligible for marrage</h1>");
		}
		else if(rage>=18 && gender.equals("female")){
			pw.println("<h1 style='color:green'>"+name+"You are eligible for marrage"+gender+"</h1>");
		}
		else if(rage>=17 && gender.equals("male")){
			pw.println("<h1 style='color:green'>"+name+"You are eligible for marrage---"+gender+"</h1>");
		}
		}
		else{
			pw.println("<h1>plz insert valid name</h1>");
		}
	}
}