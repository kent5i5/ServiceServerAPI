package com.yinkin.yinkinelderservice;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yinkin.yinkinelderservice.model.Account;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends MongoRepository<Account,String> { 
    //public Account account = (Account)find(){}
    //public Account findByUsrrName(String username);
    public List<Account> findByName(@Param("name") String name);
    public Account findByEmail(String email);
}
