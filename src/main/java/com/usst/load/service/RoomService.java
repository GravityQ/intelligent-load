package com.usst.load.service;

import com.usst.load.model.Room;

import java.util.List;

/**
 * @author junlin.qi on 2018/8/14
 */
public interface RoomService {
	List<Room> selectByCode(String coede);
}
