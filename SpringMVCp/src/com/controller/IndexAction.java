package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	
	@RequestMapping("/{path}")
	public String page(@PathVariable String path){
		return path;
	}
	
}
