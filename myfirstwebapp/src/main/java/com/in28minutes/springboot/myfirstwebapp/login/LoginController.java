package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService;

//	private Logger logger = LoggerFactory.getLogger(getClass());

	// login
//	@RequestMapping(value="login", method=RequestMethod.GET)
	@GetMapping("/login")
	public String gotoLoginPage() {

		return "login";
	}

//	@RequestMapping(value="login", method=RequestMethod.POST)
	@PostMapping("/login")
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String pw, ModelMap model) {

		if (authenticationService.authenticate(name, pw)) {

			model.put("name", name);
			model.put("password", pw);

			// authentication을 통해서 특정 사용자만 메인 페이지로 입장
			// name : sample 
			// pw: sample

			return "welcome";
		}
		
		return "login";
	}

}
