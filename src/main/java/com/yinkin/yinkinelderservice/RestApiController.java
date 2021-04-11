package com.yinkin.yinkinelderservice;

import java.io.Console;
import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import com.yinkin.yinkinelderservice.model.Account;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping({ "/api" })
public class RestApiController {
    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;
    private final Logger log = LoggerFactory.getLogger(RestController.class);
    
    public RestApiController(AccountRepository accountRepository, 
            EmployerRepository employerRepository){
        this.accountRepository = accountRepository;
        this.employerRepository = employerRepository;
    }

    //Login 
    @PostMapping(path="/user")
    ResponseEntity<Account> loginHandler2( @Valid @RequestBody String firstname) throws Exception {
        //A ccount anewAccount =
        //model.addAttribute("account", newAccount);
       
        String a = "";
        if (accountRepository.findByEmail(firstname) !=null){
            // return 
        }else{
            //accountRepository.findAll();
           // a = employerRepository.findByFirstName(firstname);
        }
        Account account = new Account();
        account.setName(firstname);
        log.info("Request with the string: {}", firstname.split(":")[1]);
        log.info("Request to create Account: {}", account.getName());
      return ResponseEntity.created(new URI("/api/user/" + a)).body(account) ;
    }

    
    @PostMapping(path="/user1")
    public @ResponseBody String loginHandler(@Valid @RequestBody String firstname) throws Exception {
        //A ccount anewAccount =
        //model.addAttribute("account", newAccount);
        String a = "";
        if (employerRepository.findByFirstName(firstname) !=null){
             // account already exists.
        }else{
            //accountRepository.findAll();
            a = "bob@b.com";
        }
        
      return "<div>this is a pass </div>";
    }

    @GetMapping
    public String apihandler(Model model){
       
        List<Employer> employerList = employerRepository.findAll();
        List<Account> acccountList = accountRepository.findAll();
        model.addAttribute("employers", employerList);
        model.addAttribute("accounts", acccountList);
        return "api/displayall";
    }
    
    @GetMapping("/user")
    public @ResponseBody String employerCheck(){
        return "this is employer ";
    }
}
