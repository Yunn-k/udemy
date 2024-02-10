package com.in28minutes.rest.webservice.restfulwebservice.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	// internalization of msg
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
//	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean with Json");
	}
	
	//path parameters
	// /users/{id}/todos/{id} => /users/2/todos/200
	// /hello-world/path-variable/lia
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s", name));
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		// 메세지 소스를 사용해서 현재 스레드에있는 locale context를 인식하고 반환하도록 함.
		return messageSource.getMessage("good.morning.message", null, "Default Msg", locale);
		
//		return "Hello World ver.2!";
		
		// 1. 각 언어에 대한 값 저장
		// good.morning.message
		// 2. 저장된 값을 코드로 가져오기
		// example: `en` - English (good Morning)
		// example: `nl` - Dutch (Goedemorgen)
		// example: `fr` - French (Bonjour)
		// example: `de` - Deutsch (Guten Morgen)
		
	}
	
}
