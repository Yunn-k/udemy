package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		
		System.out.println("Some Initionalization Logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("class B");
	}
}



@Configuration
@ComponentScan //지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class LazyInitializationLauncherApplication {
	
	

	public static void main(String[] args) {

		try (var context 
				= new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			System.out.println("initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
		}
	}
}
