package com.usst.load.ServiceImpl;

import com.usst.load.dao.RoomMapper;
import com.usst.load.model.Room;
import com.usst.load.service.RoomService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author junlin.qi on 2018/8/14
 */
@Service
public class RoomServiceImpl implements RoomService {
	@Inject
	private RoomMapper roomMapper;

	@Override
	public List<Room> selectByCode(String code) {
		return roomMapper.selectByCode(code);
	}
}
