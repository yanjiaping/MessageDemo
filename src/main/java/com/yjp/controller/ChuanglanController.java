package com.yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.service.IChuanglanService;

@RestController
public class ChuanglanController {

	@Autowired
	private IChuanglanService iChuanglanService;

	@GetMapping("/balanceDemo")
	public String balanceDemo() {
		iChuanglanService.balanceDemo();
		return "balance success!";
	}

	@GetMapping("/pullDemo")
	public String pullDemo() {
		iChuanglanService.pullDemo();
		return "pull success!";
	}
	
	@GetMapping("/reportDemo")
	public String reportDemo() {
		iChuanglanService.reportDemo();
		return "report success!";
	}
	
	@GetMapping("/sendDemo")
	public String sendDemo() {
		iChuanglanService.sendDemo();
		return "send success!";
	}
	
	@GetMapping("/variableDemo")
	public String variableDemo() {
		iChuanglanService.variableDemo();
		return "variable success!";
	}

}
