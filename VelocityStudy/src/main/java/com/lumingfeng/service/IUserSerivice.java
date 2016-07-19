package com.lumingfeng.service;


import org.springframework.stereotype.Component;

import com.lumingfeng.entity.User;

@Component
public interface IUserSerivice {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
