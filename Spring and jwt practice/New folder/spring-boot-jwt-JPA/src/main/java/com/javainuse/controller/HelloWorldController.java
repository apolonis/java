package com.javainuse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/homepage" })
	public String firstPage() {
		return "Welcome to home page";
	}

	@RequestMapping({ "/2ndpage" })
	public String secondPage() {
		return "Welcome to 2nd page";
	}



}