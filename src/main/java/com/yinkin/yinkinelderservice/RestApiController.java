package com.yinkin.yinkinelderservice;

import java.io.Console;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import com.amazonaws.util.json.JSONObject;
import com.yinkin.yinkinelderservice.model.Account;
import com.yinkin.yinkinelderservice.model.MessageRepository;
import com.yinkin.yinkinelderservice.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
* <h1>Rest Api Controller</h1>
* This controller handles request from react frontend application
* <p>
* <b>Note:</b> Underdevelopment
*
* @author  Kenneth
* @version 1.0
* @since   2020-08-11
*/
@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping({ "/api" })
public class RestApiController {
    
    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final Logger log = LoggerFactory.getLogger(RestController.class);
    
    @Autowired
    public RestApiController(AccountRepository accountRepository, 
            EmployerRepository employerRepository,UserRepository userRepository,MessageRepository messageRepository){
        this.accountRepository = accountRepository;
        this.employerRepository = employerRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        
    }

    
  /**
   * This method handles login  post http requests from the user and
   * Check if the Account exits and decides if the account
   * exits and allows login process to process.
   * @param firstname string that represents the name of the account
   * @return Account object and success state Text
   * @exception Exception On any error.
   */
    @PostMapping(path="/user")
    ResponseEntity<Account> loginHandler2( @Valid @RequestBody String username) throws Exception {
        //A ccount anewAccount =
        //model.addAttribute("account", newAccount);
        JSONObject myJsonObj = new JSONObject(username);

        String arg = myJsonObj.getString("firstname");

        Account account = new Account();
        List<Account> accountList = accountRepository.findAll();

            accountList.forEach( (acc) ->{
                log.info("----------------: {}", acc.getEmail());
                    String temp = acc.getEmail();
                    if (temp.equalsIgnoreCase(arg ) ){
                        log.info("found", acc.getEmail());
                        account.setEmail(arg );
                        
                    } 
                }
            );
      
        log.info("Request with the string: {}", myJsonObj.getString("firstname"));
        log.info("Request to create Account: {}", account.getEmail());
      if (account.getEmail().isEmpty()){
        return ResponseEntity.status(HttpStatus.SC_FORBIDDEN)
        .body(new Account());
      } else {
         // return ResponseEntity.created(new URI("/api/user/" + arg)).body(account) ;
         return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(account);
      }

    }


  /**
   * This method handle get requests 
   * @param model model data passing from UI
   * @return return list of  employer and user accounts. 
   */
    @GetMapping
    public String apihandler(Model model){
       
        List<Employer> employerList = employerRepository.findAll();
        List<Account> acccountList = accountRepository.findAll();
        model.addAttribute("employers", employerList);
        model.addAttribute("accounts", acccountList);
        return "api/displayall";
    }
    
    // @GetMapping("/user")
    // public @ResponseBody String employerCheck(){
    //     return "this is employer ";
    // }
}
