package com.khm.service;

import java.util.List;

import com.khm.dto.DiaryDto;

public interface DiaryService {
	public List<DiaryDto> readDiary(DiaryDto dto); 
	public DiaryDto diaryDeteil(DiaryDto dto); 
	public int diaryWrite(DiaryDto dto);
}
