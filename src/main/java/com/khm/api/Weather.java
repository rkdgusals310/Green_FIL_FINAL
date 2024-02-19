package com.khm.api;

/* Java 1.8 샘플 코드 */

import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "files:src/main/webapp/WEB-INF/spring/root-context.xml")

@Component
public class Weather {
	public Map<String, String> weather() throws IOException {
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		Calendar now2 = Calendar.getInstance();
		String nowTime2 = sdf2.format(now2.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		Calendar now = Calendar.getInstance();
		String nowTime = sdf.format(now.getTime());
		nowTime+="00";
//		System.out.println(nowTime2);
		
		switch(nowTime) {

        case "0200":
        case "0300":
        case "0400":
        	nowTime = "0200";
            break;
        case "0500":
        case "0600":
        case "0700":
        	nowTime = "0500";
            break;
        case "0800":
        case "0900":
        case "1000":
        	nowTime = "0800";
            break;
        case "1100":
        case "1200":
        case "1300":
        	nowTime = "1100";
            break;
        case "1400":
        case "1500":
        case "1600":
        	nowTime = "1400";
            break;
        case "1700":
        case "1800":
        case "1900":
        	nowTime = "1700";
            break;
        case "2000":
        case "2100":
        	nowTime = "2000";
            break;
        case "2200":
        case "2300": 
        case "0000":
        case "0100":
        	nowTime = "2300";

    }
		System.out.println(nowTime);
		
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=a984mZ0ZgsZHKbw2kSM1f4SU7fXWjOvnmDah0hIkAlX%2BtNc0hZv0RK7Vgs36dQ7yXjoK8ZBn%2FcZ9dJecwiHKcA%3D%3D"); /* Service Key */
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("1000", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
				+ URLEncoder.encode("JSON", "UTF-8")); /* 요청자료형식(XML/JSON) Default: XML */
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
				+ URLEncoder.encode(nowTime2, "UTF-8")); /* ‘21년 6월 28일 발표 */
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
				+ URLEncoder.encode(nowTime, "UTF-8")); /* 06시 발표(정시단위) */
		urlBuilder.append(
				"&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /* 예보지점의 X 좌표값 */
		urlBuilder.append(
				"&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /* 예보지점의 Y 좌표값 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
		System.out.println(sb.toString());
		String data = sb.toString();
		System.out.println("파싱 시작");

		// Json parser를 만들어 만들어진 문자열 데이터를 객체화
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(data);
		// response 키를 가지고 데이터를 파싱
		JsonObject parse_response = (JsonObject) obj.get("response");
		// response 로 부터 body 찾기
		JsonObject parse_body = (JsonObject) parse_response.get("body");
		// body 로 부터 items 찾기
		JsonObject parse_items = (JsonObject) parse_body.get("items");

		// items로 부터 itemlist 를 받기
		JsonArray parse_item = (JsonArray) parse_items.get("item");

		JsonObject weather = new JsonObject();
		String fcstTime;
		String category;
		String value;

		int dataSize = parse_item.size() / 10;

		String sky = null;
		String tmn = null;
		String tmx = null;
		String tmp = null;

			for (int k = 0; k < 12; k++) {
				weather = (JsonObject) parse_item.get(k);
				fcstTime = weather.get("fcstTime").getAsString();
				category = weather.get("category").getAsString();
				value = weather.get("fcstValue").getAsString();

				if (category.equals("SKY")) {
					System.out.println(fcstTime + " : " + category + "  " + value);
					sky = value;
				}
				if (category.equals("TMN")) {
					System.out.println(fcstTime + " : " + category + "  " + value);
					tmn = value;
				}
				if (category.equals("TMX")) {
					System.out.println(fcstTime + " : " + category + "  " + value);
					tmx = value;
				}
				if (category.equals("TMP")) {
					System.out.println(fcstTime + " : " + category + "  " + value);
					tmp = value;
				}

			}

//		System.out.println("끝");
//		String sky=null;
//		switch(num) {
//			case "1":
//				sky="맑음";
//				break;
//			case "3":
//				sky="구름 많음";
//				break;
//			case "4":
//				sky="흐림";
//				break;
//		}
		System.out.println("오늘의 날씨:"+sky);
		System.out.println("최고기온:"+tmx+"℃");
		System.out.println("최저기온:"+tmn+"℃");
		System.out.println("현재기온:"+tmp+"℃");
		Map<String, String> map=new HashMap<String, String>();
		map.put("sky", sky);
		map.put("tmp", tmp);
		return map;
	}
}
