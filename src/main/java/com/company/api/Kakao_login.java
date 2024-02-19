package com.company.api;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class Kakao_login {

	public String kakaoToken(String code){
		
		String client_id = "d00005ed65e673d8957a8eb42c7007d5";
		String redirect_uri = "http://localhost:8080/project_FIL/kakao.js&response_type=code&scope=account_email,gender,birthday&prompt=select_account";

		String tokenUrl = "https://kauth.kakao.com/oauth/token?";
		tokenUrl += "grant_type=authorization_code" + "&client_id=" + client_id + "&redirect_uri=" + redirect_uri
				+ "&code=" + code;
		
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
		String userinfoUrl="https://kapi.kakao.com/v2/user/me";
		url = new URL(userinfoUrl);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer "+token);
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
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
		JsonObject props=(JsonObject) job.get("properties");
		JsonObject kaccount=(JsonObject) job.get("kakao_account");
		
		String id=job.get("id").getAsString();
		String nickname = props.get("nickname").getAsString();
		String profile_image=props.get("profile_image").getAsString();
		String email = kaccount.get("email").getAsString();
		String birthday = kaccount.get("birthday").getAsString();
		String gender = kaccount.get("gender").getAsString();
		
		result.put("id", id);
		result.put("nickname", nickname );
		result.put("profile_image", profile_image); 
		result.put("email", email);
		result.put("birthday", birthday);
		result.put("gender", gender);
		return result;
		
		
	}
	
}
