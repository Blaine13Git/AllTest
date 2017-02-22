package com.windsing.myTest;
/*
 * 
//第一种方式：  
Class c1 = Class.forName("Employee");  

//第二种方式：  
//java中每个类型都有class 属性.  
Class c2 = Employee.class;  
   
//第三种方式：  
//java语言中任何一个java对象都有getClass 方法  
Employee e = new Employee();  
Class c3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee) 

================================

Class c =Class.forName("Employee");  
//创建此Class 对象所表示的类的一个新实例  
Objecto = c.newInstance(); //调用了Employee的无参数构造方法. 
 *
 */

import com.windsing.testSource.People;

public class ReflectClass {
	
	String class_name = this.getClass().getName();
	
	public void test(){
		int s = class_name.lastIndexOf("."); 
		System.out.println("class_name:"+class_name);
		System.out.println("s = " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReflectClass rc = new ReflectClass();
		rc.test();
		
	}

}
