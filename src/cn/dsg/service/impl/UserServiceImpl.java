package cn.dsg.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.dsg.dao.UserMapper;
import cn.dsg.pojo.User;
import cn.dsg.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")
    private UserMapper mapper;
	
	@Override
	public User selectName(String userId) {
		return this.mapper.selectName(userId);
	}

	@Override
	public boolean loginCheck(String userName, String userPwd,HttpServletRequest request) {
		User user = this.mapper.slectUserByName(userName);
		boolean flag = false;
		if(user!=null && userPwd.equals(user.getUserPwd())){//短路验证
			//session设置
			HttpSession session=request.getSession();
			session.setAttribute("userId",user.getUserId());
			session.setAttribute("isLogin",true);
			flag = true;
		}
		return flag;
	}

	@Override
	public void loginOutSystem(User user,HttpServletRequest request) {
		request.getSession().removeAttribute("userId");
		request.getSession().setAttribute("isLogin",false);
	}
}
