package com.zyp.service.imp;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyp.bean.User;
import com.zyp.mapper.UserMapper;
import com.zyp.service.UserService;

@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImp implements UserService{

	@Autowired
	UserMapper mapper; 
	@Override
	public User login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return mapper.login(userName,passWord);
		
	}

}
