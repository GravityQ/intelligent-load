package com.usst.load.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 货物
 *
 * @author junlin.qi on 2018/7/27
 */
@Data
@ToString
public class Goods {

	private Integer id;
	/**
	 * 货物编号
	 */
	private String code;
	/**
	 * 货物名称
	 */
	private String goodsName;
	/**
	 * 货物来源
	 */
	private String goodsOrigin;
	/**
	 * 货物重量,单位为kg
	 */
	private Float weight;
	/**
	 * 货物长度,单位cm
	 */
	private Integer length;
	/**
	 * 货物宽度,单位cm
	 */
	private Integer width;
	/**
	 * 货物高度,单位cm
	 */
	private Integer high;
	/**
	 * 是否可以旋转，0代表可以任意旋转，1代表可以水平旋转，2代表不可旋转
	 */
	private Integer turn;

	/**
	 * 获取货物的体积
	 *
	 * @return 货物体积
	 */
	public Integer getVolume() {
		return this.length * this.width * this.high;
	}
}
