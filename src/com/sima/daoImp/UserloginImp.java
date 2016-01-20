package com.sima.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sima.dao.UserloginDao;

public class UserloginImp implements UserloginDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//��ȡsession
	public Session getMySession(){
		if (sessionFactory.getCurrentSession() != null) {
			return sessionFactory.getCurrentSession();
		} else {
			return sessionFactory.openSession();
		}
	}
	
	@Override
	public String checkUserNameAndPwd(String userName,String pwd)
	{
		String result="0";                             //�û������������   
		String hql="select userPwd from TbUserlogin user where userName=:customername";
		Query query=getMySession().createQuery(hql);
		query.setString("customername", userName);
		List<String> list=query.list();
		if(!list.isEmpty()||list.size()>1)       //˵�����û�����
		{
			if(list.get(0).equals(pwd))
			   result="1";                     //˵��������ȷ
		}
		return result;
	}

	@Override
	public String updatePwd(String userName, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		String result="0";                         //˵�����Ĳ��ɹ�
		if(checkUserNameAndPwd(userName,oldPwd).equals("1")) //˵����ʼ������ȷ
		{
			String hql="update TbUserlogin set userPwd=:customerpwd where userName=:customername";
			Query query=getMySession().createQuery(hql);
			query.setString("customerpwd",newPwd);
			query.setString("customername",userName);
			query.executeUpdate();
			result="1";
		}
		return result;
	}
	
}