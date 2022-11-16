package com.hadiuz.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hadiuz.crud.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	public Login findByUserNameAndPassword(String userName, String password);

}
