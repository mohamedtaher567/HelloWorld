package com.eventum.helloworld.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eventum.helloworld.service.ReadSpreadsheet;
import com.eventum.helloworld.service.TestService;
import com.google.gdata.util.ServiceException;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
	@Autowired
	TestService testService;

	@Autowired
	ReadSpreadsheet reader;
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("helloworld");
		try {
			mv.addObject("message", reader.getSheet());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("name", name);
		return mv;
	}
	@RequestMapping("/bye")
	public ModelAndView byeMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in bye method");
		
		ModelAndView mv = new ModelAndView("byeworld");
		mv.addObject("message", "Good Bye! ");
		mv.addObject("name", name);
		return mv;
	}
}