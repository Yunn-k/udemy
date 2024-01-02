package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args)  {
		try (//1. launch a Spring context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//3. Retrieving Beans managed by Spring
//		System.out.println(context.getBean("name")); //getBean(이름)인데 이 이름은 메서드명!
			System.out.println(context.getBean("person")); 
			System.out.println(context.getBean("person3Parameters")); 
			System.out.println(context.getBean("hometown")); 
			System.out.println(context.getBean("person4Qualifier")); 
			
			System.out.println(context.getBean(Address.class)); 
			//모든 이름을 나열하기
//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. configure the things that we want spring to manage - @Configuration
		//HelloWorldConfiguration- @Configuration
		//name- @Bean

		
		
	}

}


