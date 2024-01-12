package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception { //Bean이 Spring Application안에 있을때 실행된다는 의미
//jdbc, jpa 메서드는 insert
		//		repository.insert(new Course(1L, "Learn Aws 1 Jpa", "in28minutes"));
//		repository.insert(new Course(2L, "Learn Azur 1 Jpa", "in25minutes"));
//		repository.insert(new Course(3L, "Learn Devops 1 Jpa", "in23minutes"));
		
		// springDataJpa의 메서드는 save
		repository.save(new Course(1L, "Learn Aws 1 Jpa", "in28minutes"));
		repository.save(new Course(2L, "Learn Azur 1 Jpa", "in25minutes"));
		repository.save(new Course(3L, "Learn Devops 1 Jpa", "in23minutes"));
		
		repository.deleteById(1L);
		
		System.out.println(repository.findById(2L));
		System.out.println(repository.findById(3L));
		System.out.println("---------------------------");
		System.out.println(repository.findAll());
		System.out.println(repository.findByAuthor("in23minutes"));
		System.out.println(repository.findByName("Learn Azur 1 Jpa"));
		System.out.println(repository.count());
	}

}
