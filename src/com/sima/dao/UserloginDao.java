package com.sima.dao;

public interface UserloginDao {

	//�û���¼
	public String checkUserNameAndPwd(String userName,String pwd);
	//�޸�����
	public String pwdModify(String userName, String originPwd, String newPwd);
}
