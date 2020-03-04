package com.zyp.service.imp;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyp.bean.User;
import com.zyp.config.AdminProperties;
import com.zyp.mapper.UserMapper;
import com.zyp.service.UserService;

@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImp implements UserService{

	@Autowired
	UserMapper mapper;
	// 得到管理员的信息
	@Autowired
	AdminProperties adminPro;
	@Override
	public Boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
	  return (adminPro.getAdminName().equals(userName) 
				&& adminPro.getPassword().equals(passWord));
		
	}

}
