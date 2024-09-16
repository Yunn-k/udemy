package com.in28minutes.rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	// api버전 관리 구현
	
	//path를 구분
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie"); // String으로만 이름 관리
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie")); //name 객체로 이름 관리
	}
	
	// 파라미터로 구분
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRqstParams() {
		return new PersonV1("Bob Charlie"); // String으로만 이름 관리
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRqstParams() {
		return new PersonV2(new Name("Bob", "Charlie")); //name 객체로 이름 관리
	}
	
	// 헤더로 구분 > X-API-VERSION 이라는 특정 헤더 적용
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRqstHeader() {
		return new PersonV1("Bob Charlie"); 
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRqstHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//Accept-language (accpet header) 사용 : 어떤 형식의 미디어타입을 원하는지 지정해서 보내는 헤더
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie"); 
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie")); 
	}
}
	