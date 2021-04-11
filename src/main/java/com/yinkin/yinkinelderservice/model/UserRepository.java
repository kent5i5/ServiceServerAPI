package com.yinkin.yinkinelderservice.model;

import org.springframework.data.repository.CrudRepository;



/**
* <h1>UserRepository</h1>
* This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository extending
* CrudRepository which provides Create, Read, Update, Delete methods
*
* @author  Kenneth
* @version 1.0
* @since   2020-08-11
*/
public interface UserRepository extends CrudRepository<User, Integer> {

}