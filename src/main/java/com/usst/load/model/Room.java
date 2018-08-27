package com.usst.load.model;

import lombok.Data;

import java.util.Date;

/**
 * 装载空间,装载器
 */
@Data
public class Room {
	private Long id;
	/**
	 * 空间代号
	 */
	private String code;
	/**
	 * 坐标,默认0,0,0
	 */
	private Integer[] xyz;
	/**
	 * X轴方向,长
	 */
	private Integer xLength;
	/**
	 * Y轴方向,宽
	 */
	private Integer yLength;
	/**
	 * z轴方向 高
	 */
	private Integer zLength;

	private Date createTime;

	private Date updateTime;

	public Integer getVolume() {
		return this.xLength * this.yLength * this.zLength;
	}

}