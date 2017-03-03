package cn.dsg.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.dsg.pojo.User;
import cn.dsg.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	        
	@Resource(name = "userService")
	private UserService service;
	
	@ResponseBody
	@RequestMapping(value="/loginCheck.do",method=RequestMethod.POST)
	public String loginCheck(String userName,String userPwd,HttpServletRequest request){
		return this.service.loginCheck(userName, userPwd,request)+"";
	}
	//回到首页
	@RequestMapping(value="/backToLogin.do")
	public String backToLogin(){
		return "redirect:/login.html";
	}
	//注销用户
	@RequestMapping(value="/loginOut.do")
	public void loginOut(@RequestBody User user,HttpServletRequest request){
		System.out.println(user.toString());
		this.service.loginOutSystem(user, request);
	}
}
