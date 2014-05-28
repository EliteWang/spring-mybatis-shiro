package com.easyjob.service;

import java.util.List;

import com.easyjob.domain.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int id);
	public void save(User user);
	public void delete(int id);
	public void update(User user);
	public User findByNameAndPwd(String username,String password);
}
