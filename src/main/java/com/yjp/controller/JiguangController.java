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
		return "所有平台，所有设备，内容为NOTIFICATION的通知";
	}

	@GetMapping("/jiguangDemo2")
	public String jiguangDemo2() {
		iJiguangService.jiguangDemo2();
		return "所有平台，推送目标是别名为alias1，通知内容为NOTIFICATION";
	}

	@GetMapping("/jiguangDemo3")
	public String jiguangDemo3() {
		iJiguangService.jiguangDemo3();
		return "平台是Android，目标是标签为tag1的设备，内容是Android通知NOTIFICATION，并且标题为TITLE";
	}

	@GetMapping("/jiguangDemo4")
	public String jiguangDemo4() {
		iJiguangService.jiguangDemo4();
		return "ios!";
	}

	@GetMapping("/jiguangDemo5")
	public String jiguangDemo5() {
		iJiguangService.jiguangDemo5();
		return "平台是 Andorid 与 iOS， 推送目标是 （tag1与tag2的并集）交（alias1与alias2的并集）， 推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。";
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
