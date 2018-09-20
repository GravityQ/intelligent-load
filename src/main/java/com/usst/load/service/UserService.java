package com.usst.load.service;

import com.usst.load.dao.UserMapper;
import com.usst.load.model.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author junlin.qi on 2018/9/18
 */
@Service
public class UserService {
	@Inject
	private UserMapper userMapper;
	public User selectById(Integer id) {
		return userMapper.selectById(id);
	}

	public User select(User user) {
		return userMapper.select(user.getUserName(),user.getPassword());
	}
}
