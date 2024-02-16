package com.company.dao;

import java.util.List;

import com.khm.dto.DiaryDto;

@MyDao
public interface DiaryDao {
	public List<DiaryDto> readDiary(); 
	public DiaryDto diaryDeteil(DiaryDto dto); 
	public int diaryWrite(DiaryDto dto);
	
}
