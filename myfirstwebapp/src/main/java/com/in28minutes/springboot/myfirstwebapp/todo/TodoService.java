package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
		todos.add(new Todo(++todosCount, "sample", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "sample", "Lean Devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "sample", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
}
