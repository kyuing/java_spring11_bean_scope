package com.javalec.beanScope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);	//student1
		System.out.println();
		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		System.out.println();
		
		Student student2 = ctx.getBean("student", Student.class);	//student2
		student2.setName("Dabbee Kim");
		student2.setAge(9);
		System.out.println("Name: " + student2.getName());
		System.out.println("Age: " + student2.getAge());
		System.out.println();
		
		
		
		/* Even though the values (output) are different, student1 and student2 are subject to the ID "student".
		   Because each of an instance get a bean  from the ID "student".
		   In turn, They have the same resource memory address
		    
		   Let's see if their resources come from the same memory address even though they output differently by having an if statement*/
		if (student1.equals(student2)) {
			System.out.println("student1 == student2");
			
		}else {
			System.out.println("student1 != student2");
		}
	}
}
