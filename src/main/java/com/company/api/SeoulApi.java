package com.company.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class SeoulApi {
	public Map<String, Object> historyTour() throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("51524b696573657534304b4f424c58","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("tbHanyangPoi","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode("64","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		//urlBuilder.append("/" + URLEncoder.encode("KORN_TTL","UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String infoResult=sb.toString();
		System.out.println("@@@@@@@@"+ infoResult);
		
		JsonParser parser=new JsonParser();
		JsonObject job=(JsonObject) parser.parse(infoResult);
		JsonArray read=(JsonArray) job.getAsJsonObject("tbHanyangPoi").getAsJsonArray("row");
		System.out.println(read);
		List<Map<String, Object>> result=new ArrayList<>();
			for(JsonElement one : read) {
			JsonObject read_one=one.getAsJsonObject();
			String ITRST_BRNCH_NO=read_one.get("ITRST_BRNCH_NO").getAsString();
			String KORN_TTL=read_one.get("KORN_TTL").getAsString();
			String KORN_CONTS=read_one.get("KORN_CONTS").getAsString();
			Map<String, Object> map=new HashMap<>();
						
			map.put("No", ITRST_BRNCH_NO);
			map.put("Title", KORN_TTL);
			map.put("Content", KORN_CONTS);
			result.add(map);
			}
			Map<String, Object> seoulInfo = new HashMap<>();
			seoulInfo.put("seoulInfo", result);
			
		return seoulInfo;
	}
	public Map<String, Object> historyNearTour() throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("51524b696573657534304b4f424c58","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("tbHanyangNearby","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode("27","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		//urlBuilder.append("/" + URLEncoder.encode("KORN_TTL","UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;
		
		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String infoResult=sb.toString();
		System.out.println("@@@@@@@@"+ infoResult);
		
		JsonParser parser=new JsonParser();
		JsonObject job=(JsonObject) parser.parse(infoResult);
		JsonArray read=(JsonArray) job.getAsJsonObject("tbHanyangNearby").getAsJsonArray("row");
		System.out.println(read);
		List<Map<String, Object>> result=new ArrayList<>();
		for(JsonElement one : read) {
			JsonObject read_one=one.getAsJsonObject();
			String title=read_one.get("TITLEKOR").getAsString();
			String introduce=read_one.get("INTRODUCEKOR").getAsString();
			Map<String, Object> map=new HashMap<>();
			
			map.put("Title", title);
			map.put("Content", introduce);
			result.add(map);
		}
		Map<String, Object> seoulNearInfo = new HashMap<>();
		seoulNearInfo.put("seoulNearInfo", result);
		
		return seoulNearInfo;
	}
}
