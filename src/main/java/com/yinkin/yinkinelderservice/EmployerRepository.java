package com.yinkin.yinkinelderservice;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employer", path = "employer")
public interface EmployerRepository extends MongoRepository<Employer, String> {

  public Employer findByFirstName(String firstName);
  public List<Employer> findByLastName(@Param("lastname") String lastName);
  public List<Employer> findByAddress(String address);

}