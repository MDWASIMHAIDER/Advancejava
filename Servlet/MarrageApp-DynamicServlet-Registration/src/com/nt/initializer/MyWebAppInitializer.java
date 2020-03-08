package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarrageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {

	static {
		System.out.println("myinitialize static block");
	}
    public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer 0-param constructor");
	}
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup(-,-)");
		MarrageServlet ms=null;
		ServletRegistration.Dynamic reg=null;
		ms=new MarrageServlet();
		reg=ctx.addServlet("marraige",ms);
		reg.addMapping("/marraigeurl");
		reg.setLoadOnStartup(1);

	}

}
