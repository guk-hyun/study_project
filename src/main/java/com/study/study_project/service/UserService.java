package com.study.study_project.service;

import com.study.study_project.domain.dto.UserDTO;

public interface UserService {
	boolean join(UserDTO user);
	
	boolean checkId(String userid);
	
	UserDTO login(String userid, String userpw);
}
