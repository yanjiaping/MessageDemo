package com.yjp.controller;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//import com.google.code.kaptcha.Producer;

@RestController
public class KaptchaController {

	/*
	 * @Autowired private Producer kaptchaProducer;
	 * 
	 * @Autowired RedisTemplate<String, String> redisTemplate;
	 * 
	 * @GetMapping("/kaptchaTest") public void kaptchaTest(String key,
	 * HttpServletResponse response) throws Exception {
	 * response.setDateHeader("Expires", 0); response.setHeader("Cache-Control",
	 * "no-store, no-cache, must-revalidate"); response.addHeader("Cache-Control",
	 * "post-check=0, pre-check=0"); response.setHeader("Pragma", "no-cache");
	 * response.setContentType("image/jpeg"); // 生成验证码 String capText =
	 * kaptchaProducer.createText(); // 放入redis缓存
	 * redisTemplate.opsForValue().set("CODE:" + key, capText.toLowerCase(), 60,
	 * TimeUnit.SECONDS); // 向客户端写出 BufferedImage bi =
	 * kaptchaProducer.createImage(capText); ServletOutputStream out =
	 * response.getOutputStream(); ImageIO.write(bi, "jpeg", out); out.flush();
	 * out.close(); }
	 * 
	 * @GetMapping("/example") public String getHello(@RequestHeader HttpHeaders
	 * headers) { Set<Entry<String, List<String>>> entrySet = headers.entrySet();
	 * for (Entry<String, List<String>> entry : entrySet) {
	 * System.out.println(entry.getKey() + ":" + entry.getValue()); } return
	 * "example"; }
	 */

}
