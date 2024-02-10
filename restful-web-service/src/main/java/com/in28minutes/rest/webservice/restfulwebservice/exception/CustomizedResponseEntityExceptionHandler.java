package com.in28minutes.rest.webservice.restfulwebservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	
	//get - 조회하려는 id가 없을때는 커스텀한 UserNotFoundException 클래스를 쓰도록 지정
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFound(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); //리턴타입도 raw가 아니도록 지정해줌
	}
	
	// post- validation 을 통과하지 못했을때 띄울 메세지 설정
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

// 에러메세지 리턴 케이스1. 설정한 메세지가 나오도록 한다
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

// 에러메세지 리턴 케이스 2. 간단한 디폴트 메세지만 나오게 한다. 단 첫번째 오류에 대한것만 나옴
		ErrorDetails errorDetails 
		= new ErrorDetails(LocalDateTime.now()
				, "total Errors: " + ex.getErrorCount() + ", msg: " + ex.getFieldError().getDefaultMessage()
				, request.getDescription(false));
		
// 에러메세지 리턴 케이스 3. 반복문을 이용해 모든 에러 케이스의 메세지가 나오도록 한다. 이때는 message 타입이 List로 바뀌어야 한다
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getFieldErrors(), request.getDescription(false));
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}



