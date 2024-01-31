package com.study.study_project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

	public final static String serviceKey = "d696952ee3d6dce4877e754f0537c1d7343985ded810a8e43de7a6478fcf9d14/";

	@Override
	public ArrayList<List<String>> getlist(String key) throws IOException {

		ArrayList<List<String>> all = new ArrayList<>();

		String responseText = "";
		List<String> list = new ArrayList<>();

		String url = "http://211.237.50.150:7080/openapi/" + serviceKey + "json/";
		url += "Grid_20150827000000000226_1/";
		url += "/1/100";

		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;

		while ((line = br.readLine()) != null) {

			responseText += line;

		}
		JSONObject jsonDataObject = new JSONObject(responseText);
		JSONArray rowArray = jsonDataObject.getJSONObject("Grid_20150827000000000226_1").getJSONArray("row");

		for (int i = 0; i < rowArray.length(); i++) {
			JSONObject rowObject = rowArray.getJSONObject(i);
			list = new ArrayList<>();
			if ((rowObject.get("RECIPE_NM_KO").toString()).contains(key) && key != null) {
				// 예시로 필요한 데이터를 list에 추가
				list.add(rowObject.get("TY_CODE").toString()); // 음식 분류 코드
				list.add(rowObject.get("LEVEL_NM").toString()); // 난이도
				list.add(rowObject.get("SUMRY").toString()); // 간단한 설명
				list.add(rowObject.get("RECIPE_NM_KO").toString()); // 음식이름
				list.add(rowObject.get("PC_NM").toString()); // 가격
				list.add(rowObject.get("CALORIE").toString()); // 칼로리
				list.add(rowObject.get("IRDNT_CODE").toString()); // 재료별 분류명
				list.add(rowObject.get("TY_NM").toString()); // 음식분류
				list.add(rowObject.get("RECIPE_ID").toString()); // 레시피 코드
				list.add(rowObject.get("NATION_NM").toString()); // 유형 분류
				list.add(rowObject.get("QNT").toString()); // 분량
				list.add(rowObject.get("NATION_CODE").toString()); // 유형 코드
				list.add(rowObject.get("COOKING_TIME").toString()); // 조리 시간
			}
			// 다른 필요한 데이터도 추가 가능
			all.add(list);
		}
		return all;
	}

	@Override
	public ArrayList<List<String>> getlist2(int foodcode) throws IOException {

		System.out.println(foodcode);

		ArrayList<List<String>> all = new ArrayList<>();

		String responseText = "";
		List<String> list = new ArrayList<>();

		String url = "http://211.237.50.150:7080/openapi/" + serviceKey + "json/";
		url += "Grid_20150827000000000228_1/";
		url += "?RECIPE_ID=" + foodcode;

		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;

		while ((line = br.readLine()) != null) {

			responseText += line;

		}
		JSONObject jsonDataObject = new JSONObject(responseText);
		JSONArray rowArray = jsonDataObject.getJSONObject("Grid_20150827000000000228_1").getJSONArray("row");

		for (int i = 0; i < rowArray.length(); i++) {
			JSONObject rowObject = rowArray.getJSONObject(i);
			list = new ArrayList<>();
			// 예시로 필요한 데이터를 list에 추가
			list.add(rowObject.get("COOKING_NO").toString()); // 요리설명순서
			list.add(rowObject.get("COOKING_DC").toString()); // 요리설명
			list.add(rowObject.get("STEP_TIP").toString()); // 과정팁
			// 다른 필요한 데이터도 추가 가능
			all.add(list);
		}
		return all;
	}

	@Override
	public ArrayList<List<String>> getlist3(int foodcode) throws IOException {

		ArrayList<List<String>> all = new ArrayList<>();

		String responseText = "";
		List<String> list = new ArrayList<>();

		String url = "http://211.237.50.150:7080/openapi/" + serviceKey + "json/";
		url += "Grid_20150827000000000227_1/";
		url += "?RECIPE_ID=" + foodcode;

		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;

		while ((line = br.readLine()) != null) {

			responseText += line;

		}
		JSONObject jsonDataObject = new JSONObject(responseText);
		JSONArray rowArray = jsonDataObject.getJSONObject("Grid_20150827000000000227_1").getJSONArray("row");

		for (int i = 0; i < rowArray.length(); i++) {
			JSONObject rowObject = rowArray.getJSONObject(i);
			list = new ArrayList<>();
			// 예시로 필요한 데이터를 list에 추가
			list.add(rowObject.get("IRDNT_SN").toString()); // 재료순번
			list.add(rowObject.get("IRDNT_NM").toString()); // 재료명
			list.add(rowObject.get("IRDNT_CPCTY").toString()); // 재료용량
			list.add(rowObject.get("IRDNT_TY_CODE").toString()); // 재료타입 코드
			list.add(rowObject.get("IRDNT_TY_NM").toString()); // 재료타입명
			// 다른 필요한 데이터도 추가 가능
			all.add(list);
		}
		return all;
	}
}
