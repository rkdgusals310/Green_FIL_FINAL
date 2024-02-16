package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.MainContentDao;
import com.company.dto.MainContentDto;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MainContentDao dao;
	
	@Override
	public int insert_history(MainContentDto dto) {
		return dao.insert_history(dto) ;
	}

	@Override
	public List<MainContentDto> list_history(MainContentDto dto) {
		return dao.list_history(dto);
	}

}
