package com.company.service;

import java.util.List;

import com.company.dto.UserVoDto;
import com.company.dto.MainContentDto;
import com.company.dto.UserDto;

public interface UserService {
	public List<UserDto> readAll();
	public UserDto select_user(UserDto dto);
	public UserDto loginInfo(UserDto dto);
	public List<UserDto> select_admin();
	public UserDto loginUser(UserDto dto);
	public List<UserVoDto> contentList(UserVoDto vodto);
	public int insert_user(UserDto dto);
	public int insert_api(UserDto dto);
	public int update_user(UserDto dto);
	public int delete_user(UserDto dto);
	public UserDto find_id(UserDto dto);
	public UserDto find_pass(UserDto dto);
	public int admin_plus(UserDto dto);
	public int admin_delete(UserDto dto);
	public int delete_myconetent(UserDto dto);
}
