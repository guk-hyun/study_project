package com.study.demo.service;

import com.kh.demo.domain.dto.UserDTO;

public interface UserService {
	boolean join(UserDTO user);
	
	boolean checkId(String userid);
	
	UserDTO login(String userid, String userpw);
}
