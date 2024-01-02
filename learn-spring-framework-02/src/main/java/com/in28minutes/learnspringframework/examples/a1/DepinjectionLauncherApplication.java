package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan // 지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class DepinjectionLauncherApplication {

	@Component // 스캔 대상이 됨
	class YourBusinessClass {

//		@Autowired // bean 객체들 간에 dependency injection이 되도록 함.-- field injection
		Dependency1 dependency1;

//		@Autowired
		Dependency2 dependency2;

		//@Autowired // -- constructor injection. 생성자주입시에는 autowired가 필수가 아님
		public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
			super();
			System.out.println("constructor Injection - YourBusinessClass");
			this.dependency1 = dependency1;
			this.dependency2 = dependency2;
		}

//		@Autowired //-- setter injection
//		public void setDependency1(Dependency1 dependency1) {
//			System.out.println("Setter Injection - setDependency1");
//			this.dependency1 = dependency1;
//		}
//
//		@Autowired
//		public void setDependency2(Dependency2 dependency2) {
//			System.out.println("Setter Injection - setDependency2");
//			this.dependency2 = dependency2;
//		}

		public String toString() {
			return "Using " + dependency1 + " and " + dependency2;
		}
	}

	@Component
	class Dependency1 {

	}

	@Component
	class Dependency2 {

	}

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(DepinjectionLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(YourBusinessClass.class));

		}
	}
}
