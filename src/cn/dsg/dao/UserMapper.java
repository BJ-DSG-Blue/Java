package cn.dsg.dao;

import cn.dsg.pojo.User;

public interface UserMapper {
	
	public User slectUserByName(String userName);
	
	public User selectName(String userId);

}
