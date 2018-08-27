package com.usst.load.model;

import lombok.Data;
import lombok.ToString;
import org.unbescape.css.CssIdentifierEscapeLevel;

import java.util.Comparator;
import java.util.Date;

/**
 * 货物
 *
 * @author junlin.qi on 2018/7/27
 */
@Data
@ToString
public class Goods implements Comparable {

	private Integer id;
	/**
	 * 货物编号,唯一标识
	 */
	private String code;
	/**
	 * 货物名称
	 */
	private String name;
	/**
	 * 货物来源
	 */
	private String origin;
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
	 * 货物放置坐标
	 */
	private Integer[] xyz;
	/**
	 * 是否经过旋转
	 */
	private Integer truned;

	private Date createTime;

	private Date updateTime;

	/**
	 * 获取货物的体积
	 *
	 * @return 货物体积
	 */
	public Integer getVolume() {
		return this.length * this.width * this.high;
	}

	@Override
	public int compareTo(Object o) {
		Goods otherGoods = (Goods) o;
		if (this.getCode().equals(otherGoods.getCode()) || this.isEqualXYZ(otherGoods)) {
			return 0;
		}
		if (this.getVolume() > otherGoods.getVolume()) {
			return 1;
		} else {
			return -1;
		}
	}

	private boolean isEqualXYZ(Goods other) {
		return this.getLength().equals(other.getLength()) && this.getWidth().equals(other.getWidth()) && this.getHigh().equals(other.getHigh()) ? true : false;
	}
}
