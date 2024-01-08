package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception { //Bean이 Spring Application안에 있을때 실행된다는 의미
		repository.insert(new Course(1L, "Learn Aws 1 now", "in28minutes"));
		repository.insert(new Course(2L, "Learn Azur 1 now", "in25minutes"));
		repository.insert(new Course(3L, "Learn Devops 1 now", "in23minutes"));
	}

}
