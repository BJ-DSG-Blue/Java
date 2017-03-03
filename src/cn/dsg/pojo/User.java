package cn.dsg.pojo;

import java.io.Serializable;

public class User implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int userId;
	
	private String userName;
	
	private String userPwd;

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
}