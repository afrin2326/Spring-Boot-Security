package com.iostream.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyController 
{
	
	@GetMapping("/guest")
	public String openGuestPage()
	{
		return "this is guest page";
		
	}
	
	
	@GetMapping("/admin")
	public String openAdminPage()
	{
		return "this is admin page";
		
	}

}
