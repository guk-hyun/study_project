package com.study.study_project.service;

import com.study.study_project.domain.dto.UserDTO;
import com.study.study_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper umapper;

	@Override
	public boolean checkId(String userid) {
		return umapper.findById(userid) == null;
	}
	@Override
	public boolean join(UserDTO user) {
		return umapper.insertUser(user) == 1;
	}
	@Override
	public UserDTO login(String userid, String userpw) {
		UserDTO user = umapper.findById(userid);
		if(user != null) {
			if(user.getUserpw().equals(userpw)) {
				return user;
			}
		}
		return null;
	}
}








