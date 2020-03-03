package com.zyp.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zyp.bean.User;

public interface UserMapper {

	@Select("SELECT * FROM hg_user u WHERE u.`username`=#{userName} AND u.`password`=#{passWord}")
	User login(@Param("userName")String userName,@Param("passWord")String passWord);
	 
}
