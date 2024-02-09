package com.in28minutes.rest.webservice.restfulwebservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservice.restfulwebservice.user.UserNotFoundException;


//exception handler, initBinder등 모든 클래스가 알고있어야 할 내용을 명시하고 공유하는 어노테이션
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {	
	
	//필요한 부분을 그대로 가져옴(handleException 메서드인데 final은 오버라이드 불가해서 메서드명만 바꿔줌)
	//전체 에러를 처리하도록 설정
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//id가 없을때는 커스텀한 UserNotFoundException 클래스를 쓰도록 지정
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFound(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); //리턴타입도 raw가 아니도록 지정해줌
	}
	
}
