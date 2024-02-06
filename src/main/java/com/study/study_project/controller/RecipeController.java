package com.study.study_project.controller;


import com.study.study_project.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Controller
@RequestMapping("/recipe/*")
public class RecipeController {
    @Autowired
    @Qualifier("recipeServiceImpl")
    private RecipeService service;

    final static String serviceKey = "cdb797625f4162a6663741f4f8c38eb07db17d825fba8b7535a91d7873e19dc3";

    @GetMapping("recipe-main")
    public void replace() {}

    @ResponseBody
    @PostMapping(value = "recipe-main", produces = "application/json;chraset=utf-8")
    public String getData(int START_INDEX, int END_INDEX,String recipe_NM,String IRDNT_NM, String RECIPE_ID) throws Exception {

        String url = "http://211.237.50.150:7080/openapi/"+serviceKey+"/json/Grid_20150827000000000226_1";
        url += "/"+START_INDEX;
        url += "/"+END_INDEX;
//        url += "/"+1;
//        url += "/"+1000;
        if (recipe_NM != null) {
            url += "?RECIPE_NM_KO=" + recipe_NM;
        }
        //단순한 문자열로 정의한 url을 자바에서 활용할 수 있는 객체로 변환
        URL requestURL = new URL(url);
        //목적지로 향하는 다리 건설
        HttpURLConnection conn = (HttpURLConnection)requestURL.openConnection();

        conn.setRequestMethod("GET");

        //conn 다리가 건설되어 있는 목적지로부터 데이터를 읽어와야 함
        //1. conn 목적지로 InputStream 생성( conn.getInputStream() )
        InputStream is = conn.getInputStream();
        //2. 생성된 InputStream을 이용하기 위한 객체 생성( new InputStreamReader(is) )
        InputStreamReader isr = new InputStreamReader(is);
        //3. InputStreamReader 객체보다 편한 BufferedReader 사용을 위해 객체 생성
        BufferedReader br = new BufferedReader(isr);

        //생성된 BufferedReader를 이용해서 데이터를 읽고 활용하기
        String result = "";
        String line = "";
        while(true) {
            line = br.readLine();
            if(line == null) { break; }
            result += line;
        }

//		System.out.println(result);

        br.close();
        conn.disconnect();

        System.out.println("result : " + result);
        return result;
    }
}

