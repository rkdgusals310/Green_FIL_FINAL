package com.company.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Random {
	public String random_code() {
		String code="";
		for(int i=0; i<4; i++) {			
			String random = String.valueOf((int)(Math.random()*10));
			code+=random;
		}
		System.out.println(code);
		return code;
	}
	
	public String random_mobile() {
		String code="010";
		for(int i=0; i<8; i++) {
			
			String random=String.valueOf((int)(Math.random()*10));
			code+=random;
		}
		System.out.println("@@@@"+code);
		
		return code;
	}
	
	public Set<String> random_api(List<String> list) {
		Set<String> randomList=new HashSet<>();
		for(;;) {
			int random=((int)(Math.random()*list.size()));
			System.out.println(list.get(random)); 
			
			randomList.add(list.get(random));
			if(randomList.size()==5) {
				break;
			}
		}
		
		return randomList;
	}
}
