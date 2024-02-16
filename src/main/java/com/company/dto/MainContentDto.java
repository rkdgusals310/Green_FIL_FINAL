package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainContentDto {
	private int main_no;
	private String main_title;
	private String main_content;
	private int weather_no;
}
