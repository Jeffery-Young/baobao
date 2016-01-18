package com.shijing.daoImp;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shijing.bean.TbPackage;
import com.shijing.dao.PackageDao;

public class PackageDaoImp implements PackageDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//�����ݿ��� �������ײͲ�ѯ����
	@Override
	public List<TbPackage> packageList() {
		// TODO Auto-generated method stub
		List<TbPackage>list=null;
		String queryString="from TbPackage tp order by orginalPrice Desc";
		Query query=getMySession().createQuery(queryString);
		list=query.list();
		return list;
	}

	//��ȡsession
	public Session getMySession(){
		if (sessionFactory.getCurrentSession() != null) {
			return sessionFactory.getCurrentSession();
		} else {
			return sessionFactory.openSession();
		}
	}
	
	//����ײ�
	@Override
	public String packageAdd(String priceString, String infoString,
			String photoString) {
		try {
		   Timestamp time=new Timestamp(System.currentTimeMillis());
			TbPackage tbPackage=new TbPackage();
			tbPackage.setOrginalPrice(priceString);
			tbPackage.setCurrentPrice(priceString);
			tbPackage.setDetailInfo(infoString);
			tbPackage.setPictureAddress(photoString);
			tbPackage.setCreateTime(time);
			getMySession().save(tbPackage);
		    return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	
	}
	
}
