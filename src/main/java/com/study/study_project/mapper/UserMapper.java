package com.study.study_project.mapper;

import com.study.study_project.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insertUser(UserDTO user);
	
	UserDTO findById(String userid);
}
