package cn.dsg.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.dsg.pojo.User;
import cn.dsg.service.UserService;

/**
 * 1.前台key-value字符串拼接参数get方式发送请求，后台零散参数接收
 * 2.前台json对象后台用Pojo类接收
 * 3.调用service->dao->mapper实现->查询数据库记录并返回
 * 4.页面跳转(有两种方式：返回string类型和ModelAndView)
 * 5.页面跳转并传值
 * 6.Session值的绑定
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private final Log log = LogFactory.getLog(getClass());
	
	@Resource(name = "userService")
	private UserService service;
	
	@ResponseBody
	//完整版@RequestMapping配置,可以根据需要删除里面的参数值produces配置是为了过滤前台接收值乱码,method参数设置是为了严格要求get和post方式
	@RequestMapping(value="/findUserName.do",produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String testString(String userId) {//最简格式
		//前台url传值采用get提交方式传值则参数以param1=XX&param2=XX..拼接格式传值
		this.log.info("日志测试");
		System.out.println("String...+"+userId);
		return "String请求返回值->"+userId;
	}
	//@RequestBody自动注解，前台post方式提交，参数以json数据格式--->对应Pojo类
	@ResponseBody
	@RequestMapping(value="/findUser.do",produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String testPojo(@RequestBody User user) {
		//适合表单提交:一般是post方式提交，前台传值的方式采用json字符串形式
		//1.<mvc:annotation-driven></mvc:annotation-driven>或者在xml单独配置java对象和json串之间的转换参数 
		//2.需要导入jacson相关的jar包
		System.out.println("Pojo...+"+user.getUserId());
		return "Pojo请求返回值->"+user.getUserId();
	}
	
	//调用service-dao层实现
	@ResponseBody
	@RequestMapping(value="/findMap.do",produces="application/x-www-form-urlencoded;charset=UTF-8")
	public String testMap(String userId) {
		System.out.println("userId->"+userId);
		String userName = this.service.selectName(userId).getUserName();
		System.out.println(userName);
		return "service到dao->mapper.xml查询数据库的值->"+userName;
	}

	
/*页面跳转：重定向 (reidrect:/    默认指向的目录是webroot下的目录)*/
	
	//基本页面跳转控制
	@RequestMapping(value="/redirectPage.do")
	public String redirectPage(){
		return "redirect:/page/page.jsp";
	}
	//回到首页
	@RequestMapping(value="/backToIndex.do")
	public String backToIndex(){
		return "redirect:/index.jsp";
	}
	
	//不带文件后缀根据视图配置跳转控制
	@RequestMapping(value="/loginToIndex.do")
	public ModelAndView trst(){
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request 的 setAttribute, 在 jsp 页面中通过 itemList 取数据  
//      modelAndView.addObject("itemsList", itemsList);
        // 指定视图  
        modelAndView.setViewName("/index");
		return modelAndView;
	}
	
	
	//页面跳转传参设置
	@RequestMapping(value="/redirectPageWithParams.do")
	public String redirectPageWithParams(String qtParam){
		System.out.println("redirectPageWithParams---->接收前台的值:"+qtParam);
		String value = "value1";
		String value2 = "value2";
		return "redirect:/page/page.jsp?param1="+value+"&param2="+value2; 
	}
	
}