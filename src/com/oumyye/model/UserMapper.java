package com.oumyye.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("select * from user where name=#{id}")
	User selectUser(String name);
	
	@Insert("insert into user(name) values(#{name})  ")	   
	   void addUser(User user);

}
