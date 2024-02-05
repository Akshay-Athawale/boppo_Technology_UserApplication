package com.boppo.userApplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boppo.userApplication.respository.UserRepository;

@Service
public class PasswordService {
	
	@Autowired
	UserRepository userRepository;
	
	

}
