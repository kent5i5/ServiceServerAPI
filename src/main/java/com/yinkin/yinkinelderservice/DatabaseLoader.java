package com.yinkin.yinkinelderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yinkin.yinkinelderservice.model.Account;

@Component
public class DatabaseLoader implements CommandLineRunner { 

	/**
	 *
	 */
	private final EmployerRepository repository;
	private final AccountRepository acccountRepository;

	@Autowired 
	public DatabaseLoader(EmployerRepository repository, AccountRepository accountRepository) {
		this.repository = repository;
		this.acccountRepository = accountRepository;
	}

	@Override
	public void run(String... strings) throws Exception { 
	
	}
}