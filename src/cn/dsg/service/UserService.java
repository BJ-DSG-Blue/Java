package cn.dsg.service;

import javax.servlet.http.HttpServletRequest;

import cn.dsg.pojo.User;

public interface UserService {
	public abstract boolean loginCheck(String userName,String userPwd,HttpServletRequest request);
	public abstract void loginOutSystem(User user,HttpServletRequest request);
	public abstract User selectName(String userId);
}
