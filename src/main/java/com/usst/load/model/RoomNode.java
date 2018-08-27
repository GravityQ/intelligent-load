package com.usst.load.model;

import lombok.Data;

/**
 * 三叉树
 *
 * @author junlin.qi on 2018/7/30
 */
@Data
public class RoomNode {
	private Room rootRoom;
	private RoomNode zRoom;
	private RoomNode yRoom;
	private RoomNode xRoom;

	public RoomNode(Room room) {
		this.rootRoom = room;
	}


}
