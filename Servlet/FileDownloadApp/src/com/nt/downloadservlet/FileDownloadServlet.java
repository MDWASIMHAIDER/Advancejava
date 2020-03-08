package com.nt.downloadservlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		
		PrintWriter pw=null;
		//res.setContentType("text/html");
		//pw=res.getWriter();
		String fname=null;
		File file=null;
		ServletContext sc=null;
		InputStream is=null;
		ServletOutputStream sos=null;
		long length=0;
		byte[] buffer=null;
		int bytesRead=0;
		//get Servlet COntext Obj
		sc=getServletContext();
		//read file name as req params
		//fname=req.getParameter("/green.png");
		fname=sc.getRealPath("/green.png");
		//locate the file in web app
		file=new File(fname);
		//create inputstream pointing to the file
		is=new FileInputStream(file);
		//create outputstream pointing to response obj
		sos=res.getOutputStream();
		//get file length and make it as response content length
		res.setContentLengthLong(file.length());
		//get mime type of the file and make it as res content type
		res.setContentType(sc.getMimeType(fname));
		//add content-disposition response header
		res.addHeader("Content-Disposition","attachment;fileName="+fname);
		//write stream based logic to write file content to res obj
		buffer=new byte[4096];
		while((bytesRead=is.read(buffer))!=-1)
		sos.write(buffer,0,bytesRead);	
		
		
		pw.close();
	}//do get
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doGet(req,res);
	}//do post

}//class
