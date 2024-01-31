package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*JpaRepository를 상속, <관리할 Entity, pk타입>*/
public interface TodoRepository extends JpaRepository<Todo, Integer>{ 

	public List<Todo> findByUsername(String username);
}
