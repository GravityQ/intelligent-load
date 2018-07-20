package com.usst.load.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author junlin.qi on 2018/7/18
 */
@Slf4j
@Controller
public class TestController {
	@RequestMapping("/test1")
	public String test(Map map) {
		StringUtils.isBlank("test");
		map.put("message", "运行test。。。");
		log.info("运行test。。。");
		return "test1";
	}
}
