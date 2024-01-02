package com.in28minutes.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.examples.d1.LazyInitializationLauncherApplication;

@Component
class NormalClass{
	
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) // @Scope 어노테이션을 가지고 프로토타입 클래스로 설정
@Component
class PrototypeClass{
	
}


@Configuration
@ComponentScan //지정하지 않을경우 현재 클래스 스캔. 그리고 자기자신이 configuration이므로 bean으로 생성함
public class BeanScopesLauncherApplication {
	public static void main(String[] args) {

		try (var context 
				= new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			
//			System.out.println(context.getBean(NormalClass.class));
//			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
	}
}
