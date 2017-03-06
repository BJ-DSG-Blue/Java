package cn.dsg.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import cn.dsg.pojo.User;
import cn.dsg.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	        
	@Resource(name = "userService")
	private UserService service;
	
	@ResponseBody
	@RequestMapping(value="/loginCheck.do")
	public boolean loginCheck(@RequestBody User user,HttpServletRequest request){
		String userName = user.getUserName();
		String userPwd =  user.getUserPwd();
		System.out.println(userName+","+userPwd);
		return this.service.loginCheck(userName, userPwd,request);
	}
	//回到首页
	@RequestMapping(value="/backToLogin.do")
	public String backToLogin(){
		return "redirect:/login.jsp";
	}
	//注销用户
	@RequestMapping(value="/loginOut.do")
	public ModelAndView loginOut(@RequestBody User user,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(user.toString());
		this.service.loginOutSystem(user, request);
		modelAndView.setViewName("/login");
		return modelAndView;
		
	}
}
