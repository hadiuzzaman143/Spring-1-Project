package com.hadiuz.crud.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hadiuz.crud.entity.Customer;
import com.hadiuz.crud.service.CustomerService;

// user controller to handling all rest api incoming request
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService us;
	
	//save user in db table using rest api PostMapping
	@PostMapping("/saveU")
	public ResponseEntity<Customer> saveUser(@Valid @RequestBody Customer user){
		return new ResponseEntity<Customer>(us.saveUser(user), HttpStatus.CREATED);
	}
	
	// fetch user details from db table using rest api GetMapping
	@GetMapping("/getAllU")
	public List<Customer> getAll(){
		return us.getAllUser();
	}
	
	// fetch user details from db table using rest api GetMapping based on id
	@GetMapping("/getU/{uid}")
	public ResponseEntity<Customer> getU(@PathVariable("uid") int uid){
		return new ResponseEntity<Customer>(us.getUserById(uid),HttpStatus.OK);
	}
	
	//update user details in db table using rest api PutMapping based on id
	@PutMapping("/updateU/{uid}")
	public ResponseEntity<Customer> updateUser(@PathVariable("uid") int uid, @RequestBody Customer user){
			return new ResponseEntity<Customer>(us.updateUserById(user, uid), HttpStatus.OK);
		}
		
		//delete user details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteU/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") int uid){
		us.deleteUserById(uid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
				}
	@GetMapping("/getFn/{fname}")
	public List<Customer> getFname(@PathVariable String fname){
		return us.getFname(fname);
	}
	
	@GetMapping("/getLn/{lname}")
	public List<Customer> getLname(@PathVariable String lname){
		return us.getLname(lname);
	}
	
	@GetMapping("/getPh/{uphone}")
	public Customer getPhone(@PathVariable long uphone){
		return us.getPhone(uphone);
	}
}
