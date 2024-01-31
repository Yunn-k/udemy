package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


//database
// List of todos
//static list of todos -> dabaabase (h2, mysql)

//Jpa
// bean -> database

//spring boot는 entity를 발견하면 h2에 테이블을 생성함
@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name") // h2 테이블 컬럼에서 사용할 이름 설정
	private String username;
	
	@Size(min=10, message ="enter at least 10 characters") // 여기 쓰는 메세지는 404 에러창에 나올 예정 
	private String description;
	private LocalDate targetDate; // java.util.localDate가 아니라 java.time.LocalDate
	private boolean done;
	
	public Todo() {}

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
