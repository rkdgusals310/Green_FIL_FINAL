package com.company.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class Search_api {

	public Map<String, Object> NaverApi(String search) {
		String clientId = "rNzGeKDyv6_oml2GeQla"; //애플리케이션 클라이언트 아이디
        String clientSecret = "zBHTb6rbhO"; //애플리케이션 클라이언트 시크릿


        String text = search;
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        //String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // JSON 결과
       // String apiURL = "https://openapi.naver.com/v1/search/blog.json?query=" + text+"&display=1";    // JSON 결과
       String apiURL = "https://openapi.naver.com/v1/search/encyc.json?query=" + text+"&display=1";    // JSON 결과
        
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        
        System.out.println(responseBody);
        JsonParser parser=new JsonParser();
		JsonObject job=(JsonObject) parser.parse(responseBody);
		JsonArray arrays=job.getAsJsonArray("items");
		System.out.println("arrays "+ arrays);
		Map<String, Object> result= new HashMap<>();
		if(arrays!=null && arrays.size()>0) {
			
		JsonObject array=arrays.get(0).getAsJsonObject();
		String title = array.get("title").getAsString();
		String link = array.get("link").getAsString();
		//String description = array.get("description").getAsString();
		//String thumbnail = array.get("thumbnail").getAsString();
		
		result.put("title", title);
		result.put("link", link);
		//result.put("description", description);
		//result.put("thumbnail", thumbnail);
		}
		System.out.println("result "+ result);
		return result;
	}
	 private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 오류 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }
	   private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }
	   private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
	        }
	    }
}
