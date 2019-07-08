package com.yjp.chuanglan.demo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yjp.chuanglan.model.request.SmsVariableRequest;
import com.yjp.chuanglan.model.response.SmsVariableResponse;
import com.yjp.chuanglan.util.ChuangLanSmsUtil;

/**
 *
 * @author tianyh
 * @Description:变量短信发送
 */
public class SmsVariableDemo {
	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "";
	// 用户平台API密码(非登录密码)
	public static String pswd = "";

	public static void main(String[] args) throws UnsupportedEncodingException {

		// 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsVariableRequestUrl = "http://xxx/msg/variable/json";
		// 短信内容
		String msg = "【253云通讯】尊敬的{$var},您好,您的验证码是{$var},{$var}分钟内有效";
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "先生");
		map.put("code", "121234");
		String formatStr = String.format("尊敬的%s,您好,您的验证码是%s,5分钟内有效", map);
		
		// 参数组
		String params = "159*******,先生,123456,3;130********,先生,123456,3;";
		// 状态报告
		String report = "true";

		SmsVariableRequest smsVariableRequest = new SmsVariableRequest(account, pswd, msg, params, report);

		String requestJson = JSON.toJSONString(smsVariableRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsVariableRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsVariableResponse smsVariableResponse = JSON.parseObject(response, SmsVariableResponse.class);

		System.out.println("response  toString is : " + smsVariableResponse);

	}
}
