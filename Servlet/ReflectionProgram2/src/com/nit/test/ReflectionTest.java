package com.nit.test;
import java.lang.reflect.*;
import java.util.Scanner;
public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException
						,InstantiationException
						   ,IllegalAccessException {
	System.out.println("main start");
	Scanner scn =new Scanner(System.in);
	System.out.print("Enter Class for loading :");
	Class<?> cls=Class.forName(scn.nextLine());
	Object obj=cls.newInstance();
	System.out.println(obj);
	//Constructor npcon=cls.getDeclaredConstructor(String.class);
}
}
