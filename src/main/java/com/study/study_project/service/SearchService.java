package com.study.study_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SearchService {

	ArrayList<List<String>> getlist(String key) throws IOException;

	ArrayList<List<String>> getlist2(int foodCode) throws IOException;

	ArrayList<List<String>> getlist3(int foodCode) throws IOException;

}
