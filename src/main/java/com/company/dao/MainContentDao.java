package com.company.dao;

import java.util.List;

import com.company.dto.MainContentDto;

@MyDao
public interface MainContentDao {

	public int insert_history(MainContentDto dto);
	public List<MainContentDto> list_history(MainContentDto dto);
	
}
