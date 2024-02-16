package com.khm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khm.dto.BoardDto;

@Controller
public class Controller_api {
	
	@RequestMapping(value = "/calendar.khm", method = RequestMethod.GET)
	public String calendar() {
		return "calendar"; 
	}
}
