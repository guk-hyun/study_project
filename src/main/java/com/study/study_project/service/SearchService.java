package com.study.study_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SearchService {

	ArrayList<List<String>> getlist(String key) throws IOException;

	ArrayList<List<String>> number(String foodCode) throws IOException;

	ArrayList<List<String>> material(String foodCode) throws IOException;


}
