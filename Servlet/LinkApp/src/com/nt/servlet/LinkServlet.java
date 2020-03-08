package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		res.setContentType("text/html");
		Locale[] loc=null;
		String pval=null;
		pw=res.getWriter();
		pval=req.getParameter("p1");
		loc=Locale.getAvailableLocales();
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1>All County</h1>");
			loc=Locale.getAvailableLocales();
			for(Locale l1:loc) {
				/*for(int i=0;i<l1.length;i++){
				if(l1.equals("India")) {
					pw.println(l1.toString());
				}*/
				pw.println(l1.getDisplayCountry());
			}
		}
		if(pval.equalsIgnoreCase("link2")){
			pw.println("<h1>All County</h1>");
			loc=Locale.getAvailableLocales();
			for(Locale l1:loc) {
				pw.println(l1.getLanguage());
			}
		}
		if(pval.equalsIgnoreCase("link3")){
			pw.println(new Date());
		}
		
		
	}//doget closing
	public void doPost(HttpServletRequest req,
							HttpServletResponse res)throws
								ServletException,IOException{
		doGet(req,res);
	}

}
