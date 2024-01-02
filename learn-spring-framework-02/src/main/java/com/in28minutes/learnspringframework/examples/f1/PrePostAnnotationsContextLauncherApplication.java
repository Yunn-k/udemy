package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All Dependencies are ready");
	}
	
	@PostConstruct//의존성을 연결하는대로 초기화 하고 싶음 ex. 데이터베이스에서 데이터 가져오기
	public void initialize () {
		someDependency.getReady();
	}
	
	@PreDestroy //컨테이너에서 bean이 삭제되기 전에 뭔가 하고싶을때  ex. 활성화된 연결 닫기
	public void cleanup() {
		System.out.println("clean up");
	}
	
}

@Component
class SomeDependency{
	
	public void getReady() {
		System.out.println("some logic using some dependency");
	}
}

@Configuration
@ComponentScan //지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {

		try (var context 
				= new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
		
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		}
	}
}
