package com.boppo.userApplication.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.boppo.userApplication.entity.User;

public interface UserService {

	Boolean saveUser(User user);

	Boolean isUserExist(User user);

	Page<User> getUserByPage(int offSet, int pageSize);

	List<User> searchByPassswordOrEmail(String pass, String email, int pageNumber, int pageSize);
}
