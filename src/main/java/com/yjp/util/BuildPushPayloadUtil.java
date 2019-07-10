package com.yjp.util;

import java.util.HashMap;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class BuildPushPayloadUtil {

	private static final String REGISTRATION_ID = "1104a89792ded9938f7";

	/**
	 * 1.快捷地构建推送对象：所有平台，所有设备，内容为 NOTIFICATION 的通知
	 * 
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll("NOTIFICATION1");
	}

	/**
	 * 2.构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 NOTIFICATION
	 * 
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert() {
		return PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.alias("alias1"))
				.setNotification(Notification.alert("NOTIFICATION2"))
				.build();
	}

	/**
	 * 3.构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 NOTIFICATION，并且标题为 TITLE
	 * 
	 * @return
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
		return PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag("tag1"))
				.setNotification(Notification.android("NOTIFICATION3", "TITLE3", null))
				.build();
	}

	/**
	 * 4.构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息 - 通知信息是 NOTIFICATION，角标数字为
	 * 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，消息是
	 * JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	 * 
	 * @return
	 */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and("tag1", "tag_all"))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(IosNotification.newBuilder()
								.setAlert("NOTIFICATION4")
								.setBadge(5)
								.setSound("happy")
								.addExtra("from", "JPush")
								.build())
						.build())
				.setMessage(Message.content("MSG_CONTENT4"))
				.setOptions(Options.newBuilder()
						.setApnsProduction(true)
						.build())
				.build();
	}

	/**
	 * 5.构建推送对象： 平台是 Andorid 与 iOS， 推送目标是 （"tag1" 与 "tag2" 的并集）交（"alias1" 与 "alias2"
	 * 的并集）， 推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
	 * 
	 * @return
	 */
	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder()
						.addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
						.addAudienceTarget(AudienceTarget.alias("alias1"))
						.build())
				.setNotification(Notification.alert("NOTIFICATION5"))
				.setMessage(Message.newBuilder()
						.setMsgContent("MSG_CONTENT5")
						.addExtra("from", "JPush")
						.build())
				.build();
	}
	
	/**
	 * 自定义推送对象
	 * @return
	 */
	public static PushPayload customizedPushload() {
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder()
						.addAudienceTarget(AudienceTarget.registrationId(REGISTRATION_ID))
						.build())
//				.setNotification(Notification.alert(ALERT))
				.setNotification(Notification.android("I'm notification content!", "I'm title", new HashMap<String, String>()))
				.setMessage(Message.newBuilder()
						.setMsgContent("MSG_CONTENT6")
						.addExtra("from", "YJP")
						.build())
				.build();
	}

}
