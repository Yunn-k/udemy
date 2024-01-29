package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	// 사용자 이름과 패스워드를 설정할때에는 최소한 LDAP or Database사용
	// In Memory 설정자 사용

//	InMemoryUserDetailsManager 
//	InMemoryUserDetailsManger(UserDetails...users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("sample1", "pw");
		UserDetails userDetails2 = createNewUser("sample2", "pw");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN") // 나중에 BCryptPasswordEncoder로 변경
				.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() { // passwordEncoder 사용시 BCrypePasswordEncoder를 사용하도록 설정
		return new BCryptPasswordEncoder();
	}

}
