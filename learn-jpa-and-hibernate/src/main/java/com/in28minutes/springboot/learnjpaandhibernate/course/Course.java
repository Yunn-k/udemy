package com.in28minutes.springboot.learnjpaandhibernate.course;


public class Course {

	private Long id;
	private String name;
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

	//getter
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	//tostring
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
