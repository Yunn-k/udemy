package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
	
	//http요청이 들어올떄 security filter chain이 가장 먼저 작동한다
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 모든 요청을 승인하도록 처리
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());

		// 승인되지 않은 요청은 formLogin을 통해서 사용자이름, 패스워드를 인증
		//org.springframework.security.config.Customizer<T> -- customizer를 검색해서withDefaults가 있는 인터페이스를 직접 import처리함
		http.formLogin(withDefaults());
		
		//csrf 비활성화
		http.csrf().disable();
		
		// 어플리케이션 프레임 사용 비활성화
		http.headers().frameOptions().disable();
	
		return http.build();
	}

}
