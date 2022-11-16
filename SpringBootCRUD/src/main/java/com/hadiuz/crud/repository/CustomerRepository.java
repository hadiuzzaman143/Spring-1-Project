package com.hadiuz.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hadiuz.crud.entity.Customer;

// user repo extending JpaRepository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select u from Customer u where u.fname = ?1")
	List<Customer> getFname(String fname);

	@Query("select u from Customer u where u.lname = ?1")
	List<Customer> getLname(String lname);
	
	@Query("select u from Customer u where u.uphone = ?1")
	Customer getPhone(long uphone);
}
