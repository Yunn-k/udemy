package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//released in jkd16
record Person(String name, int age, Address address) {
	/* 사용자지정 메서드 설정가능 */}; // getter, setter, constructor 가 자동으로 생성된다

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {
// configuration class

	// spring context가 관리할 이름 Bean 생성
	@Bean
	public String name() {
		return "Alen";
	}

	@Bean
	public int age() {
		return 32;
	}

	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("송파구", "서울시"));
	}

	// 객체간의 관계 만들기 1)메서드 호출
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address1()); // name, age
	}

	// 객체간의 관계 만들기 2)파라미터받기
	@Bean
	@Primary
	public Person person3Parameters(String name, int age, Address hometown) {
		return new Person(name, age, hometown);
	}

	// 한정자 사용하기
	@Bean
	public Person person4Qualifier(String name, int age, @Qualifier("address3qualifier") Address hometown) {
		return new Person(name, age, hometown);
	}

	@Bean(name = "hometown") // 보통 메서드가 Bean의 이름이지만 이름을 따로 설정해줄 수 있음
	@Primary // 대표 빈으로 설정
	public Address address1() {
		var address = new Address("불당동", "천안시");
		return address;
	}

	@Bean(name = "company")
	@Qualifier("address3qualifier") // 한정자를 설정할 시 객체 외부에 사용 가능
	public Address address2() {
		var address = new Address("수내동", "분당");
		return address;
	}

}
