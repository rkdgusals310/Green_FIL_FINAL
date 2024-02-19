package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainContentDto {
	private int content_no;
	private String content_title;
	private String content;
	private int weather_no;
}
