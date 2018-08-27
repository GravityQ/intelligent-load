package com.usst.load.common;

import com.usst.load.enums.TrunEnum;
import com.usst.load.model.Goods;
import com.usst.load.model.Room;
import com.usst.load.model.RoomNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author junlin.qi on 2018/8/14
 */
@Service
public class IntelligentLoad {
	// 根据货物的优先级排序
	//Collections.sort(goodsList);
	public void loadHandler(RoomNode roomNode, LinkedList<Goods> goodsList) {
		Goods goods = goodsList.getFirst();
		//todo 货物放置
		load(roomNode, goods);
		loadHandler(roomNode.getXRoom(), goodsList);
		loadHandler(roomNode.getYRoom(), goodsList);
		loadHandler(roomNode.getZRoom(), goodsList);
	}

	private boolean load(RoomNode roomNode, Goods goods) {
		// 检查货物体积小于空间体积
		if (goods == null || goods.getVolume() > roomNode.getRootRoom().getVolume()) {
			return false;
		}
		if (!defaultLoad(roomNode, goods)) {
			switch (goods.getTurn()) {
				case 1:
					TrunEnum.XY.turn(goods);
					return defaultLoad(roomNode, goods);
				case 0:
					TrunEnum.XY.turn(goods);
					if (!defaultLoad(roomNode, goods)) {
						TrunEnum.XZ.turn(goods);
						if (!defaultLoad(roomNode, goods)) {
							TrunEnum.XZY.turn(goods);
							if (!defaultLoad(roomNode, goods)) {
								TrunEnum.YZ.turn(goods);
								if (!defaultLoad(roomNode, goods)) {
									TrunEnum.YZX.turn(goods);
									return defaultLoad(roomNode, goods);
								}
							}
						}
					}
				default:
					return false;
			}
		}
		return true;
	}

	/**
	 * @param roomNode
	 * @param goods
	 */
	//TODO 有问题,应该选择最合适的货物装载,使剩余空间最小
	private boolean defaultLoad(RoomNode roomNode, Goods goods) {
		Room rootRoom = roomNode.getRootRoom();
		if (goods.getLength() <= rootRoom.getXLength() && goods.getWidth() <= rootRoom.getYLength() && goods.getHigh() <= rootRoom.getZLength()) {
			//货物坐标
			goods.setXyz(roomNode.getRootRoom().getXyz());
			//todo 将货物从列表中去除
			//子节点
			Room xRoom = new Room();
			Room yRoom = new Room();
			Room zRoom = new Room();
			// todo 空间划分,恰好放入时??
			if (goods.getLength() >= goods.getWidth()) {
				xRoom.setYLength(goods.getLength());
				yRoom.setXLength(rootRoom.getXLength());
			} else {
				xRoom.setYLength(rootRoom.getYLength());
				yRoom.setXLength(goods.getLength());
			}
			xRoom.setXyz(new Integer[]{rootRoom.getXyz()[0] + goods.getLength(), rootRoom.getXyz()[1], rootRoom.getXyz()[2]});
			xRoom.setXLength(rootRoom.getXLength() - goods.getLength());
			xRoom.setZLength(goods.getHigh());

			yRoom.setXyz(new Integer[]{rootRoom.getXyz()[0], rootRoom.getXyz()[1] + goods.getWidth(), rootRoom.getXyz()[2]});
			yRoom.setYLength(rootRoom.getYLength() - goods.getWidth());
			yRoom.setZLength(goods.getHigh());

			zRoom.setXyz(new Integer[]{rootRoom.getXyz()[0], rootRoom.getXyz()[1], rootRoom.getXyz()[2] + goods.getHigh()});
			zRoom.setXLength(rootRoom.getXLength());
			zRoom.setYLength(rootRoom.getYLength());
			zRoom.setZLength(rootRoom.getZLength() - goods.getHigh());
			roomNode.setXRoom(new RoomNode(xRoom));
			roomNode.setYRoom(new RoomNode(yRoom));
			roomNode.setZRoom(new RoomNode(zRoom));
			return true;
		}
		return false;
	}

	/**
	 * 检查货物是否能够装入
	 *
	 * @param room
	 * @param goods
	 * @return
	 */
	private boolean checkLoad(Room room, Goods goods) {
		return goods.getVolume() > room.getVolume();
	}

}
