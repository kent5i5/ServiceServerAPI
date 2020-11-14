package com.yinkin.yinkinelderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// @Setter
// @Getter
// @NoArgsConstructor
@Document("account")
public class Account {
    @Id
    @Indexed
    private String id;

    private String username;
    private String password;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;
    private String address;
    private double lapti;
    private double longti;
    private int age;
    private boolean termsAccepted;
    public Account(){
        this.username = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.email = "";
        this.address = "";
        this.lapti = 0;
        this.longti = 0;
        this.age = 10;
        this.termsAccepted = false;
    }
    public Account(String username, String password, String name, String surname,
             String email, String address, double lapti, double longti, 
             int age, Boolean termsAccepted){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.lapti = lapti;
        this.longti = longti;
        this.age = age;
        this.termsAccepted = termsAccepted;

    }

    public String getUserName(){ return this.username;}
    public String getPassword(){ return this.password;}
    public String getName(){return this.name;}
    public String getSurName(){return this.surname;}
    public String getEmail(){return this.email;}
    public String getAddress(){return this.address;}
    public double getLapti(){return this.lapti;}
    public double getLongti(){return this.longti;}
    public int getAge(){return this.age;}
    public boolean getTermsAccepted(){return this.termsAccepted;}

    public void setUserName(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
    public void setEmail(String email){this.email = email;}
    public void setAddress(String address){this.address = address;}
    public void setLapti(double lapti){this.lapti = lapti;}
    public void setLapti(String lapti){this.lapti = Double.parseDouble(lapti);}
    public void setLongti(double longti){this.longti = longti;}
    public void setLongti(String longti){this.longti = Double.parseDouble(longti);}
    public void setAge(int age){this.age = age;}
    public void setAge(String age){this.age = Integer.parseInt(age);}
    public void setTermsAccepted(boolean termsAccepted){this.termsAccepted = termsAccepted;}
    
}
