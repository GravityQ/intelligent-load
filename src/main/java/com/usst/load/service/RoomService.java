package com.usst.load.service;

import com.usst.load.dao.RoomMapper;
import com.usst.load.model.Room;

import javax.inject.Inject;
import java.util.List;

/**
 * @author junlin.qi on 2018/8/14
 */
public class RoomService {
	@Inject
	private RoomMapper roomMapper;

	public List<Room> selectByCode(String code) {
		return roomMapper.selectByCode(code);
	}
}
