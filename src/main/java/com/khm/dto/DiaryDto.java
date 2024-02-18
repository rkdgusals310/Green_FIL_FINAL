package com.khm.dto;

import lombok.Data;

@Data
public class DiaryDto {
	private int diary_no;
	private int user_no;
	private int weather_no;
	
	private int temp;
	private String diary_title;
	private String diary_content;
	private String diary_update;
	private String weather_name;
	
	
	
}
