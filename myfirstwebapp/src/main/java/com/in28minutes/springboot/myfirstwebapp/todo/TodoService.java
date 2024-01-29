package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
//	private int id;
//	private String username;
//	private String description;
//	private LocalDate targetDate; // java.util.localDate가 아니라 java.time.LocalDate
//	private boolean done;
	
	//static을 만들기전에 새 객체로 생성
	private static List<Todo> todos = new ArrayList<>();
	
	//todo 개수 계산
	private static int todosCount = 0;
	
	//정적변수 초기화에는 블록이 필요함
	static {
		todos.add(new Todo(++todosCount, "sample1", "Learn AWS basic", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "sample2", "Lean Devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "sample1", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		// authentication의 username이 파라미터의 username과 동일할 경우 todo 반환
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username); 
		return todos.stream().filter(predicate).toList(); // 각 리스트 내역이 filter되어서 list로 리턴함
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	

	public void deleteById(int id) {
		//todo.getId() == id 이 조건을 predicate에 저장한다
		//predicate를 정의하는 가장 간단한 방법은 람다식
		
		//todo -> todo.getId() == id todo가 호출한 아이디가 parameter의 id와 일치할때 참을 반환한다.
		Predicate<? super Todo> predicate = todo -> todo.getId() == id; //Prediate는 입력조건에 따라 참/거짓을 반환하는 자바 인터페이스
		//removeif(predicate) 는 Removes all of the elements of this collection that satisfy the givenpredicate. 
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		// predicate를 정의
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		//todos를 읽어들여서 > 필터링하고 > 가장 첫번째 참을 get한다
		Todo todo = todos.stream().filter(predicate).findFirst().get();

		return todo;
	}




	
}
