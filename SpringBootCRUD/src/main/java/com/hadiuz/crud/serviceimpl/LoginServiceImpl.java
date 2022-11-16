package com.hadiuz.crud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadiuz.crud.entity.Login;
import com.hadiuz.crud.repository.LoginRepository;
import com.hadiuz.crud.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository lrepo;
	
	@Override
	public Login loginU(String userName, String password) {
		Login user = lrepo.findByUserNameAndPassword(userName, password);
		return user;
	}

}
