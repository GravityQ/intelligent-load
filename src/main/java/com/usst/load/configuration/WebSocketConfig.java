//package com.usst.load.configuration;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
///**
// * STOMP是WebSocket的子协议,使用一个基于帧的格式来定义消息
// * @author junlin.qi on 2018/7/26
// */
//@Configuration
//@EnableWebSocketMessageBroker //通过注解开启使用STOMP协议来传输基于代理（message broker）的消息，这时控制器使用@MessageMapping，就像使用@RequestMapping一样
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {//注册STOMP协议的节点（endpoint），并映射制定的url
//		//广播式,注册一个STOMP的endPoint，并制定使用SockJS协议
//		registry.addEndpoint("/endpointWisely").withSockJS();
//		//点对点式
//		registry.addEndpoint("/endpointChat").withSockJS();
//
//	}
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理(Message Broker)
//		//广播式配置一个/topic消息代理
//		//registry.enableSimpleBroker("/topic");
//		//点对点式应增加一个/queue消息代理
//		registry.enableSimpleBroker("/queue","/topic");
//	}
//}
