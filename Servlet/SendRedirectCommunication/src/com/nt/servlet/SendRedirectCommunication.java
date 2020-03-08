package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendurl")
public class SendRedirectCommunication extends HttpServlet {

	public void doGet(HttpServletRequest req, 
						HttpServletResponse res) throws
							ServletException, IOException {
		String search=null;
		String url=null;
		String sengine=null;
		search=req.getParameter("t1");
		sengine=req.getParameter("name");
		if(sengine.equalsIgnoreCase("google")) {
			url="https://www.google.co.in/search?q="+search;
		}
		if(sengine.equalsIgnoreCase("yahoo")) {
			url="https://in.search.yahoo.com/search?q="+search;
		}
		if(sengine.equalsIgnoreCase("bing")) {
			url="https://www.bing.com/search?q="+search;
		}
		
		res.sendRedirect(url);
		RequestDispatcher rd=req.getRequestDispatcher("links.html");
		rd.include(req, res);//this will not gives error because response is commited so it will not affect
		/*PrintWriter pw=null;//this code will give error
		pw=res.getWriter();
		pw.println("after dispatch");
		*/

	}

	protected void doPost(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {

		doGet(req, res);
	}

}
