package com.usst.load.model;

/**
 * @author junlin.qi on 2018/7/30
 */
public class Room {
	//初始坐标
	private String[] origin;
	//x轴方向长度
	private Integer x;
	//y方向长度
	private Integer y;
	//z轴方向长度
	private Integer z;
	private Room upRoom;
	private Room rightRoom;
	private Room afterRoom;
}
