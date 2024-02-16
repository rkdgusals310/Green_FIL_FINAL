package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeelDto {
	private int feel_no;
	private String feel_name;
	private String feel_date;
	private int user_no;
}
