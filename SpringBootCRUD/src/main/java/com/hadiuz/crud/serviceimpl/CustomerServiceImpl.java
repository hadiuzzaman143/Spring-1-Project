package com.hadiuz.crud.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadiuz.crud.entity.Customer;
import com.hadiuz.crud.exception.CustomerNotFoundException;
import com.hadiuz.crud.repository.CustomerRepository;
import com.hadiuz.crud.service.CustomerService;
 
@Service
// implementing all method of user service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository urepo;
	
	//saving user details using save() of jpaRepository
	@Override
	public Customer saveUser(Customer user) {
		
		return urepo.save(user);
		
//		String message = null;
//		urepo.save(user);
//		if(user !=null) {
//			message = "user saved";
//		}
//		return message;
	}

	// fetching all user details using finalAll() of JpaRepository
	@Override
	public List<Customer> getAllUser() {
		
		return urepo.findAll();
	}

	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	@Override
	public Customer getUserById(int uid) {
	
		return urepo.findById(uid).orElseThrow(() -> new CustomerNotFoundException("no user exists in table"));
	}

	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	//& update any contact details of user
	@Override
	public Customer updateUserById(Customer user, int uid) {
		Customer newuser = urepo.findById(uid).orElseThrow(() -> new CustomerNotFoundException("no user exists in table"));

		// updated value
		newuser.setUname(user.getUname());
		newuser.setUphone(user.getUphone());
		urepo.save(newuser);
		return newuser;
	}

	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
// delete enter user id
	@Override
	public void deleteUserById(int uid) {
		
		urepo.findById(uid).orElseThrow(() -> new CustomerNotFoundException("no user exists in table"));
		urepo.deleteById(uid);
		
//		String message = null;
//		
//		Optional<User> user = urepo.findById(uid);
//		
//		if(user.isPresent()) {
//			urepo.deleteById(uid);
//			message = new String ("deleted successfully");
//		}
//		else {
//			throw new UserNotFoundException("no user exists in table");
//		}
//		return message;
	}

	@Override
	public List<Customer> getFname(String fname) {
		
		return urepo.getFname(fname);
	}

	@Override
	public List<Customer> getLname(String lname) {
		
		return urepo.getLname(lname);
	}

	@Override
	public Customer getPhone(long uphone) {
		
		return urepo.getPhone(uphone);
	}

}
