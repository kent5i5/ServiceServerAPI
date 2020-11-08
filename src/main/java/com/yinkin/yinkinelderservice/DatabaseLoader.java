package com.yinkin.yinkinelderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner { 

	private final EmployerRepository repository;

	@Autowired 
	public DatabaseLoader(EmployerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.repository.save(new Employer("Frodo", "Baggins", "222 address"));
	}
}