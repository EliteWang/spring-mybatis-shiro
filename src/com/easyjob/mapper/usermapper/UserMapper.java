package com.easyjob.mapper.usermapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyjob.domain.User;
import com.easyjob.ext.Mapper;

@Mapper
public interface UserMapper {
	
	public List<User> findAll();
	public User findById(int id);
	public void save(User user);
	public void delete(int id);
	public void update(User user);
	public User findByNameAndPwd(@Param("username")String username,@Param("password")String password);
	
}
