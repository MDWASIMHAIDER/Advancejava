package com.nt.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center'>H.C.L Technology</h1>");
	}
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doPost(req,res);
	}
}
