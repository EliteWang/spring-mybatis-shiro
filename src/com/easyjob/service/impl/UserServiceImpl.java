package com.easyjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyjob.domain.User;
import com.easyjob.mapper.usermapper.UserMapper;
import com.easyjob.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}
	
	public User findByNameAndPwd(String username,String password) {
		return userMapper.findByNameAndPwd(username,password);
	}

	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

}
