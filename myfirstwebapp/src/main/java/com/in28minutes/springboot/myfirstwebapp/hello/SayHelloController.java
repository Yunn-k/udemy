package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String hello() {
		
		return "Hello! what are you learning today!?";
	}
	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String helloHtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("html hardcoding");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	
	// say-hello-jsp > sayHello.jsp
	//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("/say-hello-jsp")
	public String helloJsp() {
		return "sayHello";
	}
	
	
}
