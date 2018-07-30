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
	 * 货物重量,单位为kg
	 */
	private BigDecimal weight;
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
	 * 获取货物的体积
	 *
	 * @return 货物体积
	 */
	public Integer getVolume() {
		return this.length * this.width * this.high;
	}
}
