package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveDto {
	private int save_no;
	private int feel_no;
	private int content_no;
	private int user_no;
	private String save_diary_content;
	private String save_date;
	
}
