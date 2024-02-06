package com.study.study_project.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {

	void insert_code(String num);

	Object select_code(Object object);

	String select_cnt(Object object);

	void upCnt(String foodCode);
}
