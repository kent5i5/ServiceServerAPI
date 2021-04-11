package com.yinkin.yinkinelderservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.amazonaws.services.ec2.model.Address;
import com.yinkin.yinkinelderservice.model.*;


/**
* <h1>Account Controller</h1>
* The Object handles any requests sending to site_url/account and give response with model 
* objects that UI can diplays. 
* <p>
* <b>Note:</b> Underdevelopment
*
* @author  Kenneth
* @version 1.0
* @since   2020-08-11
*/
@Controller
@RequestMapping({ "/account" })
public class AccountController {
    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;

  /**
   * This Initializer create accountRepository and employerRepository 
   * Both handles extends mongodb repository class to
   * perform various mongo database functions
   * @param accountRepository This is the handler object responsible to Account object
   * @param employerRepository  This is the handler object responsible to Employer object
   */
    @Autowired
    public AccountController(AccountRepository accountRepository, 
            EmployerRepository employerRepository){
        this.accountRepository = accountRepository;
        this.employerRepository = employerRepository;
    }

   /**
   * This method is used to add two integers. This is
   * a the simplest form of a class method, just to
   * show the usage of various javadoc Tags.
   * @param numA This is the first paramter to addNum method
   * @param numB  This is the second parameter to addNum method
   * @return int This returns sum of numA and numB.
   */
    @GetMapping("/profile")
    public String index(Model model) {
        //model.addAttribute("account", new Account());
        
        return "/user/profile";
    }

 /**
   * This method is used to retrieve registered 
   * user account
   * @param model the data model coming from the user
   * @return int This returns sum of numA and numB.
   */
    @GetMapping
    public String register(Model model) {
	    model.addAttribute("account", new Account());
        return "register";
    }


  /**
   * This method is used to register new accoutn
   * with the model passing from the frontend
   * @param newAccount This is the Account object data passing from user
   * @return the redirect link to the success page 
   */
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public String registrationHandler( Account newAccount) {
     
        if (accountRepository.findByEmail(newAccount.getEmail()) !=null){
             // account already exists.
        }else{
            accountRepository.save(newAccount);
        }
        
      return "redirect:/account/register/success";
    }

    /**
   * This method is used to handle success requests
   * user account
   * @return This returns the success page
   */
    @GetMapping("/register/success")
	public ResponseEntity<String> getSuccess() {
	    return new ResponseEntity<String>(
            "Thank you for registering. <a href='/'>back</a>", HttpStatus.OK);
    }

    /**
   * This method is used to retrieve user account
   * @param model the data model coming from the user
   * @return int This returns sum of numA and numB.
   */
    @GetMapping("/list")
    //public String getSuccess() {
	public String accountListView(Model model) {
        List<Account> accountList = accountRepository.findAll();

        model.addAttribute("accounts", accountList);
	    return"/account/accountlist";
        //return "redirect:/service";
    }

    /**
   * This method is used to retrieve registered 
   * user account
   * @param newAccount The request body of the http request
   * @param PathVariable The id of the account to be replaced.
   * @return new Account
   */
    @PutMapping("/user/{id}")
    Account replaceEmployee(@RequestBody Account newAccount, @PathVariable Long id) {
        return newAccount;
    }

     /**
   * This method is used to registered new employer 
   * if the employer accout doesn't exists and the user has
   * an account already, this method create a new employer 
   * account for the user
   * @param model the data model coming from the user
   * @param name the user name of an account that want to create employer account
   * @return succuess or fail message
   */
    @GetMapping("/employer/register/{name}")
    public String registerEmployee(Model model,@PathVariable String name) {
        //List<Employer> employerList = employerRepository.findByLastName(name);
        if (employerRepository.findByFirstName(name) !=null){
            // account already exists.
       }else{
           List<Account> accountList  = accountRepository.findByName(name);
           String userAdress = "";
           for (Account account : accountList) {
            userAdress = account.getAddress();
           }
           Employer newEmployee = new Employer(name, "",  userAdress );
           employerRepository.save(newEmployee);
           model.addAttribute("accounts", accountList);
           return "/account/employerRegistered";
       }
        model.addAttribute("name", name);
        

       return "/account/accessdenied";
    }

 /**
   * Delete all accounts.
   * @param id the id of the account
   */
    @DeleteMapping("/resetdb")
    void deleteEmployee(@PathVariable Long id) {
        accountRepository.deleteAll();;
    }
}
