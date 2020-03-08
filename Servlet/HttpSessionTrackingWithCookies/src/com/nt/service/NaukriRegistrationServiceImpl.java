package com.nt.service;

import com.nt.bo.JobseekerBo;
import com.nt.dao.NaukriRegistrationDAO;
import com.nt.dao.NaukruRegistrationDAOImpl;
import com.nt.dto.JobSeekerDTO;

public class NaukriRegistrationServiceImpl implements NaukriRegistrationService{

	int count=0;
	private NaukriRegistrationDAO dao=new NaukruRegistrationDAOImpl();
	/*public NaukriRegistrationServiceImpl() {
		dao=new NaukruRegistrationDAOImpl();
	}*/
		public String register(JobSeekerDTO dto)throws Exception{
			JobseekerBo bo=null;
			bo=new JobseekerBo();
			bo.setName(dto.getName());
			System.out.println("register def "+dto.getName());
			//System.out.println(bo.getName());
			bo.setAddrs(dto.getAddrs());
			bo.setAge(dto.getAge());
			bo.setExperiance(dto.getExperiance());
			bo.setSkill(dto.getSkill());
			bo.setLocation(dto.getLocation());
			bo.setSalary(dto.getSalary());
			count=dao.insert(bo);
			System.out.println("after insert "+count);
			if(count==1) {
				return "Registration Succeeded";
			}
			else {
				return "Registration failed";
			}
		}
}
