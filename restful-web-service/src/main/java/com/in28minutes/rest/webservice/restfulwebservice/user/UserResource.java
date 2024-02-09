package com.in28minutes.rest.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//rest API를 정의
@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		List<User> userList = service.findAll();
		return userList;
	}

	@GetMapping(path = "/users/{id}")
	public User retrieveAUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null)
			throw new UserNotFoundException("id: "+ id + " has not found");
		
		return user;
	}

	// 브라우저에서는 post api를 바로 보낼 수 없으므로 api를 활용해야 함.
	// alendApiTester를 사용해보겠음.
	// create a user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);

		// ResponseEntity를 사용해서 build를 해주고, 반환값도 ResponseEntity로 바꿔준다
		// 생성된 객체를 반환할 수 있도록 하여 api 사용자가 편하게 확인할 수 있도록 한다 (보통은 로케이션 헤더를 반환)
		// location- /users/4 (최근에 등록된 값)
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
								.path("/{id}") // 현재 경로 /user에 path 추가
								.buildAndExpand(savedUser.getId()) //path 값을 getId로 가져온다
								.toUri(); //uri로 변환해서 반환

		return ResponseEntity.created(location).build();
	}

}
