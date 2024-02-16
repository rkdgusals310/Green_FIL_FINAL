package com.khm.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_date;
	private int board_hit;
	private Boolean board_open;	
	private int user_no;
	private int macro_no;
	private int status_no;
}
/*
 `board_no` INT NOT NULL AUTO_INCREMENT,
  `board_title` VARCHAR(250) NOT NULL,
  `board_content` TEXT NOT NULL,
  `board_date` Date NOT NULL DEFAULT 'CURRENT_DATE',
  ` board_hit` INT NOT NULL DEFAULT 0,
  `board_open` boolean NULL DEFAULT true,
  `user_no` INT NOT NULL,
  `macro_no` INT NOT NULL DEFAULT 0 auto_increment,
  `status_no` INT NOT NULL DEFAULT 2,
 
 */
