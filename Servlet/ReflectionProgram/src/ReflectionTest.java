//package com.nit.test;
import java.lang.reflect.*;
import java.util.Scanner;
public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException
						   ,InstantiationException
						     ,IllegalAccessException
						       , IllegalArgumentException
						        , InvocationTargetException
						          , NoSuchMethodException
						            , SecurityException
									  ,NoSuchFieldException{
	System.out.println("main start");
	//scannner for taking input from keyboard
	Scanner scn =new Scanner(System.in);
	System.out.print("Enter Class for loading :");
	//for loading a class dynamically
	Class<?> cls=Class.forName(scn.nextLine());
	//obtaining String params constructor object
	Constructor<?> npcon=cls.getDeclaredConstructor(String.class);
	Constructor<?> npcon1=cls.getDeclaredConstructor();
	//obtaining method objects
	Method met=cls.getDeclaredMethod("m1",int.class);
	Method met1=cls.getDeclaredMethod("m1");
	//accesing private method
	Method met2=cls.getMethod("m3");
	//obtaining field objects
	Field f1=cls.getDeclaredField("a");  
	Field f2=cls.getDeclaredField("b");
	Field f3=cls.getDeclaredField("c");
	//for private field accessing 
	f3.setAccessible(true);
	met2.setAccessible(true);
	//obtaing package object
	Package p1=cls.getPackage();
	//instanciating loaded class by using parametre or non parameter constructor
	//Object obj=npcon.newInstance("wasim");
	Object obj=npcon1.newInstance();
	System.out.println(p1);
	//accesing class variables
	System.out.println(f1.get(obj));
	System.out.println(f2.get(obj));
	System.out.println(f3.get(obj));
	//invoking class methods
	met.invoke(obj,5);
	met1.invoke(obj);
	met2.invoke(obj);
	System.out.println(obj);
	
}
}
