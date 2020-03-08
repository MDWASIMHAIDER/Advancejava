package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobseekerBo;

public class NaukruRegistrationDAOImpl implements NaukriRegistrationDAO {
	//@Resourse(name="Dsjndi")
	int count=0;
	final static String INSERT_QUERY="INSERT INTO NAUKRI_INFO VALUES(jsid_seq.nextval,?,?,?,?,?,?,?)";
	public Connection getPooledConnection()throws Exception {
		System.out.println("pooled() called");
		Connection con=null;
		System.out.println("con null");
		/*InitialContext ic=null;
		DataSource ds=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:comp/env/Dsjndi");
		System.out.println("ds lookup()");
		con=ds.getConnection();
		System.out.println("getconnection");*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		if(con!=null) {
		System.out.println("getconnection");
		}
		return con;
		
	}
	
	
	public int insert(JobseekerBo bo) throws Exception{
		//JobseekerBo bo=null;
		System.out.println("insert () def");
		Connection con=null;
		PreparedStatement ps=null;
		con=getPooledConnection();
		if(con!=null) {
		System.out.println("con=pool()");
		}
		con.createStatement();
		ps=con.prepareStatement(INSERT_QUERY);
		if(ps!=null && con!=null) {
		System.out.println("after preared called"+INSERT_QUERY);
		}
		ps.setString(1,bo.getName());
		//System.out.println("insert method "+bo.getName());
		ps.setString(2,bo.getAddrs());
		ps.setInt(3,bo.getAge());
		ps.setString(4,bo.getSkill());
		ps.setInt(5,bo.getExperiance());
		ps.setInt(6,bo.getSalary());
		ps.setString(7,bo.getLocation());
		System.out.println("before exceute");
		System.out.println(count);
		count=ps.executeUpdate();
		System.out.println( "after"+ count);
		con.close();
		ps.close();
		return count;
	}
}
