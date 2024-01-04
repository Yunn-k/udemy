package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	 // courses
	// course : id, name, author
	
	@RequestMapping ("courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1, "Learn AWS", "in28minutes"),
				new Course(2, "Learn Spring", "in28minutes"),
				new Course(3, "Learn Azur", "in28minutes"),
				new Course(4, "Learn GCP", "in28minutes")
				);
	}

}