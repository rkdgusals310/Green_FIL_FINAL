package com.khm.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khm.api.EMail;
import com.khm.dto.BoardDto;
import com.khm.dto.BoardVoDto;


import com.khm.dto.MacroDto;
import com.khm.service.BoardService;


@Controller
public class BoardController {
	@Autowired BoardService service;
	@Autowired EMail mail;
	
	
	
	@RequestMapping(value="/home.hm", method = RequestMethod.GET)
	public String board_home(@RequestParam(value="pstartno",defaultValue = "0") int pstartno,Model model,BoardDto bdto) {
		
		Map<String,Integer> para= new HashMap<>();
		para.put("pstartno", pstartno);
		para.put("onepagelimit", 10);
		
//		model.addAttribute("list",service_paging.listCnt(para));
//		model.addAttribute("paging",service.paging(pstartno));
		
		
		model.addAttribute("readNotice",service.readNotice());
		model.addAttribute("rootQueList",service.rootQueList());
		model.addAttribute("noticeList",service.noticeList());
		model.addAttribute("readQue",service.readQue(para));
		model.addAttribute("paging",service.paging(pstartno));
		model.addAttribute("myQueList",service.myQueList(bdto));
		return "home"; 
	}
	
	@RequestMapping(value="/search_user.hm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search_user(BoardVoDto dto,Model model) {
		Map<String,Object> para= new HashMap<>();
		para.put("para",service.search_home(dto));
		System.out.println(dto.getKeyword());
		System.out.println(dto.getOption());
		return para;
	}
	
	@RequestMapping(value="/detail_que.hm", method = RequestMethod.GET)
	public String detail_que(BoardVoDto dto,Model model) {
		model.addAttribute("queDetail",service.queDetail(dto));
		return "write_user_detail";
	}
	
	@RequestMapping(value="/write_user.hm", method = RequestMethod.GET)
	public String write_user() {
		return "write_user";
	}
	
	@RequestMapping(value="/write_user.hm", method = RequestMethod.POST)
	public void write_user(BoardDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		
		if(service.queWrite(dto)>0) {
			out.print("<script>alert('글쓰기 성공'); location.href='"+url+"';</script>");
		}
		else {
			out.print("<script>alert('글쓰기 실패');history.go(-1);</script>");
		}
		
	}
	
	@RequestMapping(value="/edit_user.hm", method = RequestMethod.GET)
	public String edit_user(BoardVoDto dto,Model model) {
		model.addAttribute("list",service.queDetail(dto));
		return "edit_user";
	}
	
	@RequestMapping(value="/edit_user.hm", method = RequestMethod.POST)
	public void edit_user(BoardVoDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		if(service.queUpdate(dto)>0) {
			out.print("<script>alert('글 수정 성공'); location.href='"+url+"';</script>"); // 추후 디테일 부분으로 바로 이동하게 설정
			
		}
		else {
			out.print("<script>alert('글 수정 실패');history.go(-1);</script>");
		}
		
	}
	
	@RequestMapping(value="/delete_u.hm", method = RequestMethod.GET)
	public void delete_u(BoardDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		
		if(service.queDelete_u(dto)>0) {
			out.print("<script>alert('글 삭제 성공'); location.href='"+url+"';</script>");
		}
		else {
			out.print("<script>alert('글 삭제 실패');history.go(-1);</script>");
		}
		
	}
	
	
	//공지사항
	@RequestMapping(value="/notice_detail.hm", method = RequestMethod.GET)
	public String notice_detail(BoardVoDto dto,Model model) {
		model.addAttribute("noticeDetail",service.noticeDetail(dto));
		return "notice_detail";
	}
	
	@RequestMapping(value="/edit_notice.hm", method = RequestMethod.GET)
	public String edit_notice(BoardVoDto dto,Model model) {
		model.addAttribute("list",service.noticeDetail(dto));
		return "edit_notice";
	}
	
	@RequestMapping(value="/edit_notice.hm", method = RequestMethod.POST)
	public void edit_notice(BoardVoDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		if(service.noticeUpdate(dto)>0) {
			out.print("<script>alert('공지 수정 성공'); location.href='"+url+"';</script>"); // 추후 디테일 부분으로 바로 이동하게 설정
			
		}
		else {
			out.print("<script>alert('공지 수정 실패');history.go(-1);</script>");
		}
		
	}
	
	@RequestMapping(value="/delete_notice.hm", method = RequestMethod.GET)
	public void delete_notice(BoardVoDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		
		if(service.noticeDelete(dto)>0) {
			out.print("<script>alert('공지 삭제 성공'); location.href='"+url+"';</script>");
		}
		else {
			out.print("<script>alert('공지 삭제 실패');history.go(-1);</script>");
		}
		
	}
	
	@RequestMapping(value="/write_notice.hm", method = RequestMethod.GET)
	public String write_notice() {
		return "write_notice";
	}
	
	@RequestMapping(value="/write_notice.hm", method = RequestMethod.POST)
	public String write_notice(BoardVoDto dto,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		service.noticeWrite_1(dto);
		model.addAttribute("notice_write",service.noticeWrite_1_select(dto));
		return "write_day";
		
		
		
	}
	
	@RequestMapping(value="/write_notice_end.hm", method = RequestMethod.POST)
	public void write_notice_end(BoardVoDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		
		if(service.noticeWrite_2(dto)>0) {
			out.print("<script>alert('글쓰기 성공'); location.href='"+url+"';</script>");
		}
		else {
			out.print("<script>alert('글쓰기 실패');history.go(-1);</script>");
		}
		
	}
	
	
	@RequestMapping(value="/write_root_detail.hm", method = RequestMethod.GET)
	public String macro(BoardVoDto dto,Model model) {
		model.addAttribute("queDetail",service.queDetail(dto));
		model.addAttribute("answer",service.macroAnswer());
		model.addAttribute("success",service.macroSuccess(dto));
		
		return "write_root_detail";
	}
	
	@RequestMapping(value="/upedate_answer.hm", method = RequestMethod.POST)
	public void macro_answer(BoardDto ddto,HttpServletRequest request,HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+ddto.getUser_no();
		if(service.reply(ddto)>0) {
			out.print("<script>alert('매크로 성공'); location.href='"+url+"';</script>");
			mail.naverMailSend();
		}
		else {
			out.print("<script>alert('매크로 실패');history.go(-1);</script>");
		}
	}
	
	@RequestMapping(value="/macro.hm", method = RequestMethod.GET)
	public String macro_man(Model model) {
		
		model.addAttribute("answer",service.macroList());
		return "macro";
	}
	
	@RequestMapping(value="/macro_detail.hm", method = RequestMethod.GET)
	public String macro_detail(Model model,MacroDto dto) {
		
		model.addAttribute("detail",service.macroDetail(dto));
		return "macro_detail";
	}
	
	@RequestMapping(value="/delete_macro.hm", method = RequestMethod.GET)
	public void delete_macro(Model model,MacroDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		if(service.macroDelete(dto)>0) {
			out.print("<script>alert('매크로 삭제 성공'); location.href='macro.hm';</script>");
		}
		else {
			out.print("<script>alert('매크로 실패');history.go(-1);</script>");
		}
	}
	
	@RequestMapping(value="/edit_macro.hm", method = RequestMethod.GET)
	public String edit_macro(Model model,MacroDto dto) {
		
		model.addAttribute("macroDetail",service.macroDetail(dto));
		
		return "edit_macro";
	}
	
	@RequestMapping(value="/delete_r.hm", method = RequestMethod.GET)
	public void delete_r(Model model,BoardDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String url="home.hm?user_no="+dto.getUser_no();
		
		if(service.queDelete_r(dto)>0) {
			out.print("<script>alert('게시글 삭제 성공'); location.href='"+url+"';</script>");
		}
		else {
			out.print("<script>alert('게시글 실패');history.go(-1);</script>");
		}
	}
	
	@RequestMapping(value="/edit_macro.hm", method = RequestMethod.POST)
	public void edit_macro_true(Model model,MacroDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		if(service.macroUpdate(dto)>0) {
			out.print("<script>alert('매크로 수정 성공'); location.href='macro.hm';</script>");
		}
		else {
			out.print("<script>alert('매크로 실패');history.go(-1);</script>");
		}
	}
	
	
	
	@RequestMapping(value="/write_macro.hm", method = RequestMethod.GET)
	public String write_macro(Model model,MacroDto dto) {
		model.addAttribute("macroCount",service.macroCount());
		return "write_macro";
	}
	
	@RequestMapping(value="/write_macro.hm", method = RequestMethod.POST)
	public void macroWrite(Model model,MacroDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		if(service.macroWrite(dto)>0) {
			out.print("<script>alert('매크로 추가 성공'); location.href='macro.hm';</script>");
		}
		else {
			out.print("<script>alert('매크로 실패');history.go(-1);</script>");
		}
	}
	
	
	
	

	
	
}
