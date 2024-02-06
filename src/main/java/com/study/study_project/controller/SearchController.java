package com.study.study_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.study_project.mapper.SearchMapper;
import com.study.study_project.service.SearchService;

@RequestMapping("/search/*")
@Controller
public class SearchController {
	@Autowired
	private SearchService Sservice;
	@Autowired
	private SearchMapper smapper;

	@GetMapping("searchpage")
	public String search() {

		return "search/search.html";
	}
	
	@GetMapping("searchlist")
	@ResponseBody
	public ArrayList<List<String>> searchlist(String key , Model model) throws IOException {
		
		ArrayList<List<String>> set = Sservice.getlist(key);
		
		System.out.println(Sservice.getlist("밥") + "check");
		
		return set; //레시피 기본 정보
	}
	
	@GetMapping("get")
	public String get(String foodCode,Model model) throws IOException {
		smapper.upCnt(foodCode);
		model.addAttribute("number",Sservice.number(foodCode)); //레시피 과정 정보
		model.addAttribute("material",Sservice.material(foodCode)); // 레시피 재료 정보
		return "search/searchget";
	}
}