package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	// 인터페이스 형식으로 전달할 타입만 정의해주면 됨
	
	//springDataJpa는 커스터마이징 가능
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
	

}
