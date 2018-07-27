package com.usst.load.controller;

import com.usst.load.model.WiselyMessage;
import com.usst.load.model.WiselyResponse;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * WebSocket演示控制器
 *
 * @author junlin.qi on 2018/7/26
 */
@Controller
public class WsController {


	@MessageMapping("/welcome")//当浏览器向服务器发送请求时,同@MessaMapping映射/welcome这个地址,类似于@RequestMapping
	@SendTo("/topic/getResponse")//当服务端有消息时,会对订阅了@sendTo中的路径的浏览器发送消息
	public WiselyResponse say(WiselyMessage wiselyMessage) {
		return new WiselyResponse("welcome" + wiselyMessage.getName() + "!");
	}

	//点对点式
	@MessageMapping("chat")
	public void handleChat(Principal principal, String msg) {
	}
}
