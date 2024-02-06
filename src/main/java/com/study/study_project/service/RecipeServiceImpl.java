package com.study.study_project.service;


import com.study.study_project.mapper.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeMapper mapper;

}













