package com.in28minutes.rest.webservice.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// 보통은 데이터베이스와 통신하지만 지금은 Static List를 만들어서 UserDaoService와 통하도록 설정함
	
	private static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User(1, "Lia", LocalDate.now().minusYears(33)));
		userList.add(new User(2, "key", LocalDate.now().minusYears(30)));
		userList.add(new User(3, "Taemin", LocalDate.now().minusYears(34)));
		
	}
	
	 public List<User> findAll(){
		 return userList;
	 }

	// public User save(User user)
	
	 public User findOne(int id) {
		 
		 // Predicate를 사용해서 함수형 프로그래밍으로 검색
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return userList.stream().filter(predicate).findFirst().get();
		 
		//반복문을 이용해서 검색
//		 User findUser = null;
//		 
//		 for(int i=0; i<userList.size(); i++) {
//			 if(userList.get(i).getId().equals(id))
//				 findUser= userList.get(i);
//			 else
//				 continue;
//		 }
//		 return findUser;
		 
	 }
}
