package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

@Configuration
@ComponentScan // 지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
			

		}
	}
}
