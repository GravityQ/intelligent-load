package com.usst.load.common;

import com.usst.load.model.Goods;
import com.usst.load.model.Room;
import com.usst.load.model.RoomNode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author junlin.qi on 2018/8/14
 */
@Service
public class IntelligentLoad {
	public void load(List<Room> rooms, List<Goods> goodsList) {
		RoomNode roomNode = new RoomNode();
		if (rooms.size()>1) {

		}
	}
}
