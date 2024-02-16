package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVoDto {

	/*
	 * private SaveDto saveDto; private UserDto userDto; private FeelDto feelDto;
	 * private MainContentDto maincontentDto;
	 */

	private int user_no;
	private int group_no;
	private String feel_name;
	private String content_url;
	private String save_date;
	private String save_diary_content;

}
