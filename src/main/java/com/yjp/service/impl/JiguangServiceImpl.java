package com.yjp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yjp.service.IJiguangService;
import com.yjp.util.BuildPushPayloadUtil;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;

@Service
public class JiguangServiceImpl implements IJiguangService {
	private static Logger LOG = LoggerFactory.getLogger(JiguangServiceImpl.class);
	private static final String APP_KEY = "83bbfd8775c45f5b8b7da19b";
	private static final String MASTER_SECRET = "e4f785d317b00a0d94a9bc25";
	private JPushClient jPushClient;
	private PushPayload pushPayload;

	@Override
	public void jiguangDemo1() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.buildPushObject_all_all_alert();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	@Override
	public void jiguangDemo2() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.buildPushObject_all_alias_alert();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	@Override
	public void jiguangDemo3() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.buildPushObject_android_tag_alertWithTitle();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	@Override
	public void jiguangDemo4() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	@Override
	public void jiguangDemo5() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.buildPushObject_ios_audienceMore_messageWithExtras();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	/**
	 * 构建推送对象：推送内容包含SMS信息
	 */
	@Override
	public void jiguangDemo6() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY);
		try {
			SMS sms = SMS.newBuilder().setDelayTime(1000).setTempID(2000).addPara("Test", 1).build();
			PushResult result = jPushClient.sendAndroidMessageWithAlias("Test SMS", "test sms", sms, "alias1");
			LOG.info("Got result - " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	@Override
	public void jiguangDemo7() {
		jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		pushPayload = BuildPushPayloadUtil.customizedPushload();
		try {
			jPushClient.sendPush(pushPayload);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

}
