package com.company.api;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.Parser;


@Component
public class Naver_login {

	public String naverLogin(String code){
		
		String client_id = "rNzGeKDyv6_oml2GeQla";
		String client_secret="zBHTb6rbhO";
		//String redirect_uri = "http://localhost:8181/project_FIL/naver.js";

		String tokenUrl = "https://nid.naver.com/oauth2.0/token?";
		tokenUrl += "grant_type=authorization_code" + "&client_id=" + client_id +"&client_secret=" +client_secret+ "&code=" + code;
		
		String token ="";
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line = "";
		StringBuffer buffer = new StringBuffer();
		String resultToken = "";
		try {
			url = new URL(tokenUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
			conn.disconnect();
			resultToken = buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("step2)" + resultToken);
		// json
		JsonParser parser = new JsonParser();
		JsonObject job = (JsonObject) parser.parse(resultToken);
		String access_token=job.get("access_token").getAsString();
		token = access_token;
		
		System.out.println("step3) token > " + token);

		return token;
	}
	
	public Map<String, Object> getUserInfo(String token) throws Exception{
		Map<String, Object> result=new HashMap<>();
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line = "";
		StringBuffer buffer = new StringBuffer();
		String infoResult="";
	
		System.out.println(token);
		String userinfoUrl="https://openapi.naver.com/v1/nid/me";
		url = new URL(userinfoUrl);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer "+token);
		//conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		if(conn.getResponseCode()==200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		while ((line=br.readLine())!=null) {
			buffer.append(line);
		}
		br.close();
		conn.disconnect();
		infoResult= buffer.toString();
		System.out.println("STEP4) "+infoResult);
		
		JsonParser parser=new JsonParser();
		JsonObject job=(JsonObject) parser.parse(infoResult);
		JsonObject response=(JsonObject) job.get("response");
		
		String name = response.get("name").getAsString();
		String gender = response.get("gender").getAsString();
		String birthday = response.get("birthday").getAsString();
		String birthyear = response.get("birthyear").getAsString();
		String mobile = response.get("mobile").getAsString();
		String profile_image = response.get("profile_image").getAsString();
		String email = response.get("email").getAsString();
		String id=response.get("id").getAsString();
		
		result.put("name", name);
		result.put("gender", gender);
		result.put("birthday", birthday);
		result.put("birthyear", birthyear);
		result.put("mobile", mobile);
		result.put("profile_image", profile_image);
		result.put("email", email);
		result.put("id", id);
		return result;
	
		
	}
	
}
