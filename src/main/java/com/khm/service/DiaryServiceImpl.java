package com.khm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.DiaryDao;
import com.khm.dto.DiaryDto;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired DiaryDao dao;
	@Override
	public List<DiaryDto> readDiary() {
		return dao.readDiary();
	}

	@Override
	public int diaryWrite(DiaryDto dto) {
		return dao.diaryWrite(dto);
	}

	@Override
	public DiaryDto diaryDeteil(DiaryDto dto) {
		return dao.diaryDeteil(dto);
	}
	
}
