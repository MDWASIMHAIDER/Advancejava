package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.NaukriRegistrationService;
import com.nt.service.NaukriRegistrationServiceImpl;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req,
							HttpServletResponse res) throws
								ServletException, IOException {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		JobSeekerDTO dto=null;
		String skill=null;
		int age=0;
		NaukriRegistrationService service=new NaukriRegistrationServiceImpl();
		skill=req.getParameter("skill");
		age=Integer.parseInt(req.getParameter("age"));
		HttpSession ses=null;
		ses=req.getSession(false);
		//gather form1/req1 data and form2 /req2 data
		String name=(String)ses.getAttribute("name");
		String address=(String)ses.getAttribute("address");
		String location=(String)ses.getAttribute("location");
		int salary=(Integer)ses.getAttribute("salary");
		int experiance=(Integer)ses.getAttribute("experiance");
		dto=new JobSeekerDTO();
		dto.setName(name);
		dto.setAddrs(address);
		dto.setAge(age);
		dto.setExperiance(experiance);
		dto.setLocation(location);
		dto.setSalary(salary);
		dto.setSkill(skill);
		try {
			String result=service.register(dto);
			pw.println(result);
		}
		catch(Exception e) {
			/*if(((SQLException)e).getErrorCode()==1) {
				pw.println("Allready Register");
			}*/
			pw.println("Allready Register");
		}
		
	}

	@Override
	public void doGet(HttpServletRequest req,
						HttpServletResponse res) throws
							ServletException, IOException {
		doPost(req,res);
	}
	
}
