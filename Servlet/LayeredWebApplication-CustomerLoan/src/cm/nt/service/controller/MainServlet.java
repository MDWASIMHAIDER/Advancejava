package cm.nt.service.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CustomerDTo;
import com.nt.vo.CustomerVo;
@WebServlet("/controller")
@Resource(name="Dsjndi")
public class MainServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
							HttpServletResponse res)throws
								ServletException,IOException{
		System.out.println("main entered");
		CustomerVo vo=null;
		CustomerDTo dto=null;
		PrintWriter pw=null;
		res.setContentType("text/html");
		String sno=null;
		String sname=null;
		String m1=null;
		String m2=null;
		String m3=null;
		sno=req.getParameter("sno");
		sname=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
	}//do get close
	
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws
							ServletException,IOException{
			
		doGet(req,res);
	}
}
