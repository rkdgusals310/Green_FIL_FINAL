package com.company.service;

import java.util.List;

import com.company.dto.MainContentDto;

public interface MainService {
	public int insert_history(MainContentDto dto);
	public List<MainContentDto> list_history(MainContentDto dto);

}
