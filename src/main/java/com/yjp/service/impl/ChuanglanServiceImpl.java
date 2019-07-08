package com.yjp.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yjp.chuanglan.model.request.SmsBalanceRequest;
import com.yjp.chuanglan.model.request.SmsPullRequest;
import com.yjp.chuanglan.model.request.SmsReportRequest;
import com.yjp.chuanglan.model.request.SmsSendRequest;
import com.yjp.chuanglan.model.request.SmsVariableRequest;
import com.yjp.chuanglan.model.response.SmsBalanceResponse;
import com.yjp.chuanglan.model.response.SmsPullResponse;
import com.yjp.chuanglan.model.response.SmsReportResponse;
import com.yjp.chuanglan.model.response.SmsSendResponse;
import com.yjp.chuanglan.model.response.SmsVariableResponse;
import com.yjp.chuanglan.util.ChuangLanSmsUtil;
import com.yjp.service.IChuanglanService;

@Service
public class ChuanglanServiceImpl implements IChuanglanService {

	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String ACCOUNT = "N9561835";
	// 用户平台API密码(非登录密码)
	public static String PASSWORD = "mlAdhMIJLjba41";

	@Override
	public void balanceDemo() {
		String smsBalanceRequestUrl = "http://smsbj1.253.com/msg/balance/json";

		SmsBalanceRequest smsBalanceRequest = new SmsBalanceRequest(ACCOUNT, PASSWORD);

		String requestJson = JSON.toJSONString(smsBalanceRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsBalanceRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsBalanceResponse smsVarableResponse = JSON.parseObject(response, SmsBalanceResponse.class);

		System.out.println("response  toString is : " + smsVarableResponse);
	}

	@Override
	public void pullDemo() {
		System.out.println("pullDemo");
		String smsPullRequestUrl = "http://smsbj1.253.com/msg/pull/mo";
		// 上行拉取条数
		String count = "1";

		SmsPullRequest smsPullRequest = new SmsPullRequest(ACCOUNT, PASSWORD, count);

		String requestJson = JSON.toJSONString(smsPullRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsPullRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsPullResponse smsPullResponse = JSON.parseObject(response, SmsPullResponse.class);

		System.out.println("response  toString is : " + smsPullResponse);
	}

	@Override
	public void reportDemo() {
		System.out.println("reportDemo");
		String smsReportRequestUrl = "http://smsbj1.253.com/msg/pull/report";
		// 状态报告拉取条数
		String count = "20";

		SmsReportRequest smsReportRequest = new SmsReportRequest(ACCOUNT, PASSWORD, count);

		String requestJson = JSON.toJSONString(smsReportRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsReportResponse smsReportRespnse = JSON.parseObject(response, SmsReportResponse.class);

		System.out.println("response  toString is : " + smsReportRespnse.getResult());
	}

	@Override
	public void sendDemo() {
		System.out.println("sendDemo");
		// 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsSingleRequestServerUrl = "https://smsbj1.253.com/msg/send/json";
		// 短信内容
		String msg = "【创蓝253】验证码为123456，此验证码30分钟内有效，如非本人操作，请忽略此短信。";
		// 手机号码
		String phone = "13918738971";
		// 状态报告
		String report = "true";

		SmsSendRequest smsSingleRequest = new SmsSendRequest(ACCOUNT, PASSWORD, msg, phone, report);

		String requestJson = JSON.toJSONString(smsSingleRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

		System.out.println("response after request result is :" + response);

		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

		System.out.println("response  toString is :" + smsSingleResponse);
	}

	@Override
	public void variableDemo() {
		System.out.println("variableDemo");
		// 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsVariableRequestUrl = "http://smsbj1.253.com/msg/variable/json";
		// 短信内容
		String msg = "【创蓝253】您好，您的注册已经审核通过，您的登录账号为：{$var},登录密码为；{$var}";

		// 参数组
		String params = "13918738971,yjp,123456;13512112194,zsw,654321";
		// 状态报告
		String report = "true";

		SmsVariableRequest smsVariableRequest = new SmsVariableRequest(ACCOUNT, PASSWORD, msg, params, report);

		String requestJson = JSON.toJSONString(smsVariableRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsVariableRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsVariableResponse smsVariableResponse = JSON.parseObject(response, SmsVariableResponse.class);

		System.out.println("response  toString is : " + smsVariableResponse);

	}

}
