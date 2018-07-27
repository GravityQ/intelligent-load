package com.usst.load.model;

import lombok.Getter;

/**
 * 服务器向浏览器发送的消息用此类接收
 * @author junlin.qi on 2018/7/26
 */
@Getter
public class WiselyResponse {
	private String reponseMessage;

	public WiselyResponse(String reponseMessage) {
		this.reponseMessage=reponseMessage;
	}
}
