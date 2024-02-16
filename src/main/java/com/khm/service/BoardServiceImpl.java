package com.khm.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.company.dao.BoardDao;

import com.khm.dto.BoardDto;
import com.khm.dto.BoardRootDto;
import com.khm.dto.BoardVoDto;
import com.khm.dto.MacroDto;
import com.khm.paging.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDao dao;

	
	@Override
	public BoardDto readNotice() {
		return dao.readNotice();
	};// 홈에서 공지사항 읽어오기
	
	@Override
	public List<BoardVoDto> readQue(Map<String, Integer> para){
		return dao.readQue(para);
	}// 홈에서 문의사항 읽어오기
	
	@Override
	public List<BoardVoDto> search_home(BoardVoDto dto) {
		// TODO Auto-generated method stub
		return dao.search_home(dto);
	}
//	@Override
//	public List<BoardVoDto> search_home(Map<String, Integer> para) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	// 페이징
	@Override
	public PagingDto paging(int pstartno) {
		
		return new PagingDto(dao.listTotal(),pstartno);
		
	}


	@Override
	public BoardVoDto queDetail(BoardVoDto bdto) {
		dao.hit(bdto);
		return dao.queDetail(bdto);
	}// 문의사항 디테일
	
	@Override
	public int queWrite(BoardDto bdto){
		
		return dao.queWrite(bdto);
	}// 문의사항 글쓰기
	
	@Override
	public int queUpdate(BoardVoDto bdto){
		return dao.queUpdate(bdto);
	}// 문의사항 수정하기
	
	@Override
	public int queDelete_u(BoardDto bdto){
		return dao.queDelete_u(bdto);
	}// 문의사항 삭제하기(사용자)
	
	@Override
	public List<BoardVoDto> myQueList(BoardDto bdto){
		return dao.myQueList(bdto);
	}// 내 문의내역
	
	@Override
	public List<BoardDto> noticeList(){
		return dao.noticeList();
	}// 공지사항 리스트
	
	
	//관리자
	@Override
	public BoardVoDto noticeDetail(BoardVoDto bdto){
		dao.hit(bdto);
		return dao.noticeDetail(bdto);
	}// 공지사항 디테일
	
	/*
	public int noticeWrite_1(BoardDto bdto);// 공지사항 글 쓰기
	public int noticeWrite_2(BoardRootDto brdto);// 공지사항 글 쓰기
	*/
	
	
	@Override
	public int noticeWrite_1(BoardVoDto bvodto) {
		
		return dao.noticeWrite_1(bvodto);
	}
	@Override
	public int noticeWrite_2(BoardVoDto bvodto) {

		return dao.noticeWrite_2(bvodto);
	}
	
	@Override
	public BoardVoDto noticeWrite_1_select(BoardVoDto bvodto) {
		return dao.noticeWrite_1_select(bvodto);
	};
	/*
	public int noticeDelete_1(BoardDto bdto);// 공지사항 글 삭제
	public int noticeDelete_2(BoardRootDto bdto);// 공지사항 글 삭제
	*/
	@Override
	public int noticeDelete(BoardVoDto bvodto){
		dao.noticeDelete_2(bvodto);
		return dao.noticeDelete_1(bvodto);
	}// 공지사항 글 삭제
	
	/*
	public int noticeUpdate_1(BoardDto bdto);// 공지사항 글 수정
	public int noticeUpdate_2(BoardRootDto bdto);// 공지사항 글 수정
	*/
	@Override
	public int noticeUpdate(BoardVoDto bvodto){
		dao.noticeUpdate_2(bvodto);
		return dao.noticeUpdate_1(bvodto);
	}// 공지사항 글 수정
	
	@Override
	public List<BoardVoDto> rootQueList(){
		return dao.rootQueList();
	}// 관리자 문의 관리
	
	@Override
	public int reply(BoardDto bdto){
		return dao.reply(bdto);
	}// 관리자 문의 관리 답변달기
	
	@Override
	public int queDelete_r(BoardDto bdto){
		return dao.queDelete_r(bdto);
	}// 관리자 사용자가 쓴 글 삭제
	
	@Override
	public List<MacroDto> macroList(){
		return dao.macroList();
	}// 매크로 답변 리스트
	
	@Override
	public MacroDto macroDetail(MacroDto mdto){
		return dao.macroDetail(mdto);
	}// 매크로 답변 디테일
	
	@Override
	public int macroCount(){
		return dao.macroCount();
	}
	@Override
	public int macroWrite(MacroDto mdto){
		return dao.macroWrite(mdto);
	}// 매크로 답변 리스트 추가
	
	@Override
	public int macroUpdate(MacroDto mdto){
		return dao.macroUpdate(mdto);
	}// 매크로 답변 리스트 수정
	
	@Override
	public int macroDelete(MacroDto mdto){
		return dao.macroDelete(mdto);
	}// 매크로 답변 리스트 삭제

	@Override
	public List<MacroDto> macroAnswer() {
		
		return dao.macroAnswer();
	}

	@Override
	public BoardVoDto macroSuccess(BoardVoDto vodto) {
		return dao.macroSuccess(vodto);
	}


		
}
