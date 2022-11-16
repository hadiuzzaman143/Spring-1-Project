package com.hadiuz.crud.service;

import java.util.List;

import com.hadiuz.crud.entity.Customer;

//abstract method for performing CRUD on user entity
public interface CustomerService {
	
	//saving details of user 
	Customer saveUser(Customer user);
	
	//getting all details of user 
	List<Customer> getAllUser();
	
	//getting details of user based on uid
	Customer getUserById(int uid);
	
	//getting details of user based on uid & change mentioned details 
	Customer updateUserById(Customer user, int uid);
	
	//getting details of user based on uid & delete mentioned user
	void deleteUserById(int uid);
	
	
	List<Customer> getFname(String fname);

	List<Customer> getLname(String lname);
	
	Customer getPhone(long uphone);

}
