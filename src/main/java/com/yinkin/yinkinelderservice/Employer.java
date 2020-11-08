package com.yinkin.yinkinelderservice;

import org.springframework.data.annotation.Id;

public class Employer {
    
    @Id
    public String id;
  
    public String firstName;
    public String lastName;
    public String address; 
  
    public Employer() {}
  
    public Employer(String firstName, String lastName, String address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
    }
  
    @Override
    public String toString() {
      return String.format(
          "Employer[id=%s, firstName='%s', lastName='%s']",
          id, firstName, lastName);
    }
}
