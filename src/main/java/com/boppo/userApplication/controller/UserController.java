package com.boppo.userApplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boppo.userApplication.constraint.CommonConstant;
import com.boppo.userApplication.entity.User;
import com.boppo.userApplication.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("userregistration")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		logger.info(String.format(CommonConstant.REQUEST_URL, "api/user/save/registeruser"));
		logger.info(String.format(CommonConstant.REQUEST, user));
		Boolean saveUser = userService.saveUser(user);
		if (saveUser) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		logger.info(String.format(CommonConstant.RESPONSE, saveUser));
		return new ResponseEntity<User>(user, HttpStatus.ALREADY_REPORTED);
	}

	@PostMapping("userlogin")
	public ResponseEntity<Boolean> checkToLogin(@RequestBody User user) {
		logger.info(String.format(CommonConstant.REQUEST_URL, "api/user/userlogin"));
		logger.info(String.format(CommonConstant.REQUEST, user));
		Boolean userExist = userService.isUserExist(user);
		if (userExist) {
			return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
		}
		logger.info(String.format(CommonConstant.RESPONSE, userExist));
		return new ResponseEntity<Boolean>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("get/pagination/{offSet}/{pageSize}")
	public ResponseEntity<Page<User>> getStudentByPage(@PathVariable int offSet, @PathVariable int pageSize) {
		logger.info(String.format(CommonConstant.REQUEST, "api/user/get/pagination/" + offSet + "/" + pageSize));
		Page<User> studentByPage = userService.getUserByPage(offSet, pageSize);
		logger.info(String.format(CommonConstant.RESPONSE, studentByPage));
		return new ResponseEntity<Page<User>>(studentByPage, HttpStatus.OK);
	}

	@PostMapping("searchuser")
	public ResponseEntity<List<User>> jpaSearchByNameOrEmail(@RequestParam String pass, @RequestParam String email,
			@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize) {
		return new ResponseEntity<List<User>>(userService.searchByPassswordOrEmail(pass, email, pageNumber, pageSize),
				HttpStatus.OK);
	}
}
