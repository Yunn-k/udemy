package com.in28minutes.rest.webservice.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // 500이 아닌 not found를 반환하도록 지정해줌
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message); //부모클래스를 상속받아 메세지 만들기
	}
}
