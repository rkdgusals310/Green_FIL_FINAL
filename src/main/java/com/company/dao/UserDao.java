package com.company.dao;

import java.util.List;

import com.company.dto.UserVoDto;
import com.company.dto.UserDto;

@MyDao
public interface UserDao {
	public List<UserDto> selectAll();
	public UserDto loginUser(UserDto dto);
	public UserDto loginInfo(UserDto dto);
	public UserDto select(UserDto dto);
	public List<UserDto> select_admin();
	public UserDto findid(UserDto dto);
	public UserDto findpass(UserDto dto);
	public List<UserVoDto> contentList(UserVoDto vodto);
	public int insert(UserDto dto);
	public int insert_api(UserDto dto);
	public int update(UserDto dto);
	public int update_adminplus(UserDto dto);
	public int update_admindelete(UserDto dto);
	public int delete(UserDto dto); 
	public int delete_myconetent(UserDto dto);
}
