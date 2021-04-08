package com.yinkin.yinkinelderservice;

import java.util.List;

import com.yinkin.yinkinelderservice.model.Account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/api" })
public class RestApiController {
    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;

    
    public RestApiController(AccountRepository accountRepository, 
            EmployerRepository employerRepository){
        this.accountRepository = accountRepository;
        this.employerRepository = employerRepository;
    }

    @GetMapping
    public String apihandler(Model model){
       
        List<Employer> employerList = employerRepository.findAll();
        List<Account> acccountList = accountRepository.findAll();
        model.addAttribute("employers", employerList);
        model.addAttribute("accounts", acccountList);
        return "api/displayall";
    }
    
    @GetMapping("/api/employer")
    public String employerCheck(){
        return "this is employer ";
    }
}
