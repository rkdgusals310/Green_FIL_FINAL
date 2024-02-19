package com.khm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khm.api.Weather;
import com.khm.dto.BoardVoDto;
import com.khm.dto.DiaryDto;
import com.khm.dto.MacroDto;
import com.khm.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired DiaryService service;
	@Autowired Weather weather;
	
	@RequestMapping(value = "/diary.khm", method = RequestMethod.GET)
	public String diary(Model model,DiaryDto dto) throws IOException
	{
		
		model.addAttribute("readDiary",service.readDiary(dto));
		model.addAttribute("weather",weather.weather());
		return "diary_detail";	
	}
	@RequestMapping(value="/diary_detail.khm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search_user(DiaryDto dto,Model model) {
		Map<String,Object> para= new HashMap<>();
		para.put("para",service.diaryDeteil(dto));
		System.out.println(para);
		return para;
	}
	
	@RequestMapping(value = "/write_diary.khm", method = RequestMethod.POST)
	public void write_diary(Model model,DiaryDto dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		System.out.println(dto.getDiary_title());
		System.out.println(dto.getDiary_content());
		System.out.println(dto.getTemp());
		System.out.println(dto.getUser_no());
		System.out.println(dto.getWeather_no());
		if(service.diaryWrite(dto)>0) {
			out.print("<script>alert('일기 쓰기 성공'); location.href='Search.js';</script>");
		}
		else {
			out.print("<script>alert('일기 쓰기 실패');history.go(-1);</script>");
		}
	}
	
	
}
