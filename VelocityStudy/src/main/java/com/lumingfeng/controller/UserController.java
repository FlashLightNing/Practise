package com.lumingfeng.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lumingfeng.entity.User;
import com.lumingfeng.service.IUserSerivice;
import com.lumingfeng.serviceImpl.UserServiceImpl;

@RequestMapping("/user")
@Controller
public class UserController {

	@Resource(name="userService")
	private IUserSerivice userService;
	
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
	User user =	userService.selectByPrimaryKey(1);
		
	System.out.println(user);
		ModelAndView view =new ModelAndView("index");
		view.addObject("name", user);
		
		return view;
		
	}
}
