package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan //지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {

		try (var context 
				= new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
		
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		}
	}
}
