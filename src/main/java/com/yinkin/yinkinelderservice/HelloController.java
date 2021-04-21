package com.yinkin.yinkinelderservice;

import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
* <h1>Hello Controller</h1>
* This controller display base pages
* <p>
* <b>Note:</b> Underdevelopment
*
* @author  Kenneth
* @version 1.0
* @since   2020-08-11
*/
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

	

	// @GetMapping("/access-denied")
    // public String accessDenied() {
    //     return "/error/access-denied";
    // }

}