package com.nt.service;

import com.nt.bo.CustomerBo;
import com.nt.dao.CustomerDAo;
import com.nt.dto.CustomerDTo;

public class CustomerService {
	public String generateResult(CustomerDTo dto) {
		int total=0;
		float avg=0.0f;
		String result=null;
		CustomerBo bo=null;
		CustomerDAo dao=null;
		int count=0;
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35) {
			result="fail";
		}
		else {
			result="pass";
		}
		bo=new CustomerBo();
		bo.setAvg(avg);
		bo.setTotal(total);
		bo.setSname(dto.getSname());
		bo.setSno(dto.getSno());
		bo.setResult(result);
		dao=new CustomerDAo();
		//try {
	    count=dao.insert(bo);
	    if(count==0)
	    	return "Registration failed";
	    else
	    	return "Registration success";
		//}catch(Exception e) {
			//return "Registration failed"; 
		//}
	}

}
