package com.sima.service;

public interface UserloginManager {

	//�û���¼
	public String checkUserNameAndPwd(String userName,String pwd);
	//�޸�����
	public String modifyPwd(String userName, String originPwd, String newPwd);
}
