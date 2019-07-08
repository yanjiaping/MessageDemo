package com.yjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.service.IJiguangService;

@RestController
public class JiguangController {
	@Autowired
	private IJiguangService iJiguangService;

	@GetMapping("/jiguangDemo1")
	public String jiguangDemo1() {
		iJiguangService.jiguangDemo1();
		return "success！";
	}

	@GetMapping("/jiguangDemo2")
	public String jiguangDemo2() {
		iJiguangService.jiguangDemo2();
		return "success！";
	}

	@GetMapping("/jiguangDemo3")
	public String jiguangDemo3() {
		iJiguangService.jiguangDemo3();
		return "success！";
	}

	@GetMapping("/jiguangDemo4")
	public String jiguangDemo4() {
		iJiguangService.jiguangDemo4();
		return "success！";
	}

	@GetMapping("/jiguangDemo5")
	public String jiguangDemo5() {
		iJiguangService.jiguangDemo5();
		return "success！";
	}

	@GetMapping("/jiguangDemo6")
	public String jiguangDemo6() {
		iJiguangService.jiguangDemo6();
		return "success！";
	}
	
	@GetMapping("/jiguangDemo7")
	public String jiguangDemo7() {
		iJiguangService.jiguangDemo7();
		return "jiguangDemo7！";
	}
}
