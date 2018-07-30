package com.usst.load.controller;

import com.usst.load.model.Goods;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

/**
 * 货物控制层
 * @author junlin.qi on 2018/7/27
 */
@Controller
public class GoodsController {
	public void edit(Integer goodsId) {
		Goods goods=new Goods();
		System.out.println(goods.toString());
	}

	public static void main(String[] args) {
		new GoodsController().edit(3);
	}
}
