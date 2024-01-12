package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Course {

	@Id //primary key로 처리
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author") //column 이름과 매핑
	private String author;
	
	//constructor
	public Course() {
		
	}
	
	public Course(Long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	//getter & setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	//tostring
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	

}
