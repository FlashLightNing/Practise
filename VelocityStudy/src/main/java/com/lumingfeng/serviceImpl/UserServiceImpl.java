package com.lumingfeng.serviceImpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumingfeng.dao.IUserDao;
import com.lumingfeng.entity.User;
import com.lumingfeng.service.IUserSerivice;

@Service("userService")
public class UserServiceImpl implements IUserSerivice{
	
	@Resource
	private IUserDao userdao;

	public int deleteByPrimaryKey(Integer id) {
		return userdao.deleteByPrimaryKey(id);
	}

	public int insert(User record) {
		return this.userdao.insert(record);
	}

	public int insertSelective(User record) {
		return insertSelective(record);
	}

	public User selectByPrimaryKey(Integer id) {
		return 	userdao.selectByPrimaryKey(id);
		
	}

	public int updateByPrimaryKeySelective(User record) {
		return userdao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userdao.updateByPrimaryKey(record);
	}

}
