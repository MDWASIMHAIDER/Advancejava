package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.BookSearchService;

public class BookSearchController extends HttpServlet{
	
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		String category=null;
		String sourse=null;
		BookSearchService service=null;
		List<BookDTO>listDTO=null;
		RequestDispatcher rd=null;
		category=req.getParameter("category");
		sourse=req.getParameter("sourse");
		System.out.println(category+sourse);
		service= new BookSearchService();
		try {
			listDTO=service.search(category);
			System.out.println("after service serarch");
		}
		catch(Exception e) {
			rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req,res);
			return;
		}
		//keep listDTO in req attribute
		req.setAttribute("booksList",listDTO);
		System.out.println("after setting attribute");
		//forward the req to dest page based on the button clicked
		if(sourse.equals("html")) {
			System.out.println("dispatch equal");
			rd=req.getRequestDispatcher("/html_screen.jsp");
		}
		else {
			rd=req.getRequestDispatcher("/screen.jsp");
		}
		System.out.println("before forward");
		rd.forward(req,res);
		System.out.println("after forward");
	}//get
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doGet(req,res);
	}

}
