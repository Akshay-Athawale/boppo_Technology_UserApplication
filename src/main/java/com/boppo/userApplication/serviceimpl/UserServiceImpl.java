package com.boppo.userApplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.boppo.userApplication.entity.User;
import com.boppo.userApplication.respository.UserRepository;
import com.boppo.userApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Boolean saveUser(User user) {
		logger.info("Entry :: Inside UserServiceImpl :: saveUser():");
		Optional<User> userbyEmail = userRepository.findByEmail(user.getEmail());
		Boolean flag = false;

		if (userbyEmail.isEmpty()) {
			userRepository.save(user);
			logger.info("Exit :: Inside UserServiceImpl :: saveUser():");
			return flag = true;
		} else {
			logger.info("Exit :: Inside UserServiceImpl :: saveUser():");
			return flag;

		}
	}

	@Override
	public Boolean isUserExist(User user) {
		logger.info("Entry :: Inside UserServiceImpl :: isUserExist():");
		Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
		Boolean flag = false;
		if (byEmail.isPresent()) {
			User us = byEmail.get();
			if (us.getPassword().equals(user.getPassword())) {
				System.out.println("Logged In Successfully");
				flag = true;
			} else {
				logger.info("Exit :: Inside UserServiceImpl :: isUserExist():");
				throw new RuntimeException("Wrong Pass");
			}
		} else {
			logger.info("Exit :: Inside UserServiceImpl :: isUserExist():");
			throw new RuntimeException("User Not Found");

		}
		logger.info("Exit :: Inside UserServiceImpl :: isUserExist():");
		return flag;
	}

	@Override
	public Page<User> getUserByPage(int offSet, int pageSize) {
		logger.info("Entry :: Inside UserServiceImpl :: getUserByPage():");
		Page<User> allUserByPage = userRepository.findAll(PageRequest.of(offSet, pageSize));
		logger.info("Exit :: Inside UserServiceImpl :: getUserByPage():");
		return allUserByPage;
	}

	@Override
	public List<User> searchByPassswordOrEmail(String name, String email, int pageNumber, int pageSize) {
		logger.info("Entry :: Inside UserServiceImpl :: searchByPassswordOrEmail():");
		PageRequest of = PageRequest.of(pageNumber, pageSize);
		List<User> byNameOrEmail = userRepository.findByPasswordOrEmail(name, email, of);
		logger.info("Exit :: Inside UserServiceImpl :: searchByPassswordOrEmail():");
		return byNameOrEmail;
	}

}
