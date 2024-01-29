package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	@Autowired
//	private AuthenticationService authenticationService;

//	private Logger logger = LoggerFactory.getLogger(getClass());

	// login
//	@RequestMapping(value="login", method=RequestMethod.GET)
	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}

	// spring security로부터 username 받기
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		return username;
	}

// 로그인이 submit처리되었을때의 처리는 spring security로 넘어간다.

//	@RequestMapping(value="login", method=RequestMethod.POST)
//	@PostMapping("/login")
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String pw, ModelMap model) {
//
//		if (authenticationService.authenticate(name, pw)) {
//
//			model.put("name", name);
//			model.put("password", pw);
//
//			// authentication을 통해서 특정 사용자만 메인 페이지로 입장
//			// name : sample 
//			// pw: sample
//
//			return "welcome";
//		}
//		
//		model.put("errorMsg", "유효하지 않은 자격증명. 재로그인해주세요");
//		
//		return "login";
//	}

}
