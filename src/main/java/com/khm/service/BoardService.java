package com.khm.service;

import java.util.List;
import java.util.Map;

import com.khm.dto.BoardDto;
import com.khm.dto.BoardRootDto;
import com.khm.dto.BoardVoDto;
import com.khm.dto.MacroDto;
import com.khm.paging.PagingDto;

public interface BoardService {
	public BoardDto readNotice();// 홈에서 공지사항 읽어오기
	public List<BoardVoDto> readQue(Map<String, Integer> para);// 홈에서 문의사항 읽어오기
//	public List<BoardVoDto> search_home(Map<String, Integer> para);// 홈에서 문의사항 읽어오기
	public List<BoardVoDto> search_home(BoardVoDto dto);// 홈에서 문의사항 읽어오기
	public PagingDto paging(int pstartno);
	
	
	public BoardVoDto queDetail(BoardVoDto bdto);// 문의사항 디테일
	
	public int queWrite(BoardDto bdto);// 문의사항 글쓰기
	public int queUpdate(BoardVoDto bdto);// 문의사항 수정하기
	public int queDelete_u(BoardDto bdto);// 문의사항 삭제하기(사용자)
	
	public List<BoardVoDto> myQueList(BoardDto bdto);// 내 문의내역

	public List<MacroDto> macroAnswer();// 내 문의내역
	public List<BoardDto> noticeList();// 공지사항 리스트
	public int macroCount();// 공지사항 리스트

	
	
	//관리자
	public BoardVoDto noticeDetail(BoardVoDto bdto);// 공지사항 디테일
	/*
	public int noticeWrite_1(BoardDto bdto);// 공지사항 글 쓰기
	public int noticeWrite_2(BoardRootDto brdto);// 공지사항 글 쓰기
	*/
	
	public int noticeWrite_2(BoardVoDto bvodto);// 공지사항 글 쓰기
	public int noticeWrite_1(BoardVoDto bvodto);
	public BoardVoDto noticeWrite_1_select(BoardVoDto bvodto);

	/*
	public int noticeDelete_1(BoardDto bdto);// 공지사항 글 삭제
	public int noticeDelete_2(BoardRootDto bdto);// 공지사항 글 삭제
	*/
	public int noticeDelete(BoardVoDto bvodto);// 공지사항 글 삭제
	
	/*
	public int noticeUpdate_1(BoardDto bdto);// 공지사항 글 수정
	public int noticeUpdate_2(BoardRootDto bdto);// 공지사항 글 수정
	*/
	public int noticeUpdate(BoardVoDto bvodto);// 공지사항 글 수정
	
	public List<BoardVoDto> rootQueList();// 관리자 문의 관리
	
	public int reply(BoardDto bdto);// 관리자 문의 관리 답변달기
	public int queDelete_r(BoardDto bdto);// 관리자 사용자가 쓴 글 삭제
	
	public List<MacroDto> macroList();// 매크로 답변 리스트
	public MacroDto macroDetail(MacroDto mdto);// 매크로 답변 디테일
	public BoardVoDto macroSuccess(BoardVoDto vodto);// 매크로 답변 디테일
	public int macroWrite(MacroDto mdto);// 매크로 답변 리스트 추가
	public int macroUpdate(MacroDto mdto);// 매크로 답변 리스트 수정
	public int macroDelete(MacroDto mdto);// 매크로 답변 리스트 삭제
	
		
}
