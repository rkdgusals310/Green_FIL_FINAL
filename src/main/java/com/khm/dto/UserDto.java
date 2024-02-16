package com.khm.dto;

import lombok.Data;

@Data
public class UserDto {
	private int user_no;
	private String user_email;
    private String user_pass;
    private String user_name;
    private String user_birth;
    private String user_mobile;
    private String user_date;
    private String user_ip;
    private String user_login;
    private String user_sex;
    private int grade_no;
    private String grade_name;
}
