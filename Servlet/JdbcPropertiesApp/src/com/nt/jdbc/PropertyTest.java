package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTest {

	public static void main(String[] args) {
		InputStream is=null;
		Properties ps=null;
		
		try {
			//locate file using inputstraem
			is=new FileInputStream("src/com/nt/commons/personalDetails.properties");
			//load property file data into java.util.properties class obj
			ps=new Properties();
			ps.load(is);
			System.out.println("property data "+ps);
			System.out.println("name key value "+ps.getProperty("name"));
			System.out.println("age key value "+ps.getProperty("age"));
			System.out.println("address key value "+ps.getProperty("address"));
		}//
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
