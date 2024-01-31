package com.study.study_project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.study_project.service.SearchService;

@RequestMapping("/search/*")
@Controller
public class SearchController {
	@Autowired
	private SearchService Sservice;

	@GetMapping("searchpage")
	public String search() {

		return "search/search.html";
	}
	
	@GetMapping("searchlist")
	@ResponseBody
	public ArrayList<List<String>> searchlist(String key) throws IOException {
		
		ArrayList<List<String>> test = Sservice.getlist(key);
		return test;
	}
	
	@GetMapping("get")
	public String get(int foodCode,Model model) throws IOException {
		
		model.addAttribute("number",Sservice.getlist2(foodCode));
		model.addAttribute("material",Sservice.getlist3(foodCode));
		
		return "search/searchget";
	}
}