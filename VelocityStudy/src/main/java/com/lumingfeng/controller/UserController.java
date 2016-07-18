package com.lumingfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/index")
	public ModelAndView index(){
		System.out.println("11");
		ModelAndView view =new ModelAndView("index");
		view.addObject("name", "lumingfeng");
		
		return view;
		
	}
	
	@RequestMapping("/test")
	public ModelAndView test(){
		System.out.println("11");
		ModelAndView view =new ModelAndView("index.html");
		view.addObject("name", "lumingfeng");
		
		return view;
		
	}
}
