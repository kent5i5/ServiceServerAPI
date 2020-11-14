package com.yinkin.yinkinelderservice;

import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "index"; 
    }
    
    @GetMapping("/login")
    public String login( CsrfToken token) {
        
        return "login";
    }

	@GetMapping("/user")
    public String userIndex() {
        return "user/profile";
    }

	

	@GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}