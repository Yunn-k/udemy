package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional// jpa로 쿼리를 실행하려 할때마다 트랜잭션을 허용해야 함
public class CourseJpaRepository {
	
	@Autowired //@PersistenceContext 를 대신 사용해도 됨
	private EntityManager entityManager;
	
	public void insert(Course course) { //entity와 merge 처리됨
		entityManager.merge(course);
	}
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = entityManager.find(Course.class, id);// 해당 값을 먼저 찾는다
		entityManager.remove(course);
	}

}
