package com.nt.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		PrintWriter pw=null;
		Enumeration e=null;
		//File file=null;
		Hashtable<String,UploadFile>ht=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		MultipartFormDataRequest mreq=null;
		UploadBean bean=null;
		try {
		  mreq=new MultipartFormDataRequest(req);
		  bean=new UploadBean();
		  bean.setFolderstore("e:/servletupload");
		  bean.setOverwrite(false);
		  bean.setMaxfiles(6);
		  bean.store(mreq);
		  pw.println("<h1 style='color:red;text-align:center'>File uploaded succesfull</h1>");
		  ht=mreq.getFiles();
		   e=ht.elements();
		   while(e.hasMoreElements()) {
			  UploadFile file=(UploadFile)e.nextElement();
			   pw.println(file.getFileName()+".."+file.getContentType()+".."+file.getFileSize());
		   }
		}catch(Exception ex) {ex.printStackTrace();}
		pw.close();
	}//do get
	public void doGet(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
		doPost(req,res);
	}
}
