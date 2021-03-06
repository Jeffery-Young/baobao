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

	// 将数据库中 的所有套餐查询出来
	@Override
	public List<TbPackage> packageList() {
		// TODO Auto-generated method stub
		List<TbPackage> list = null;
		String queryString = "from TbPackage tp order by tp.orginalPrice Desc";
		Query query = getMySession().createQuery(queryString);
		list = query.list();
		return list;
	}

	// 获取session
	public Session getMySession() {
		if (sessionFactory.getCurrentSession() != null) {
			return sessionFactory.getCurrentSession();
		} else {
			return sessionFactory.openSession();
		}
	}

	// 添加套餐
	@Override
	public String packageAdd(String packageName,String priceString, String priceCurrent,
			String infoString) {

		try {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			TbPackage tbPackage = new TbPackage();
			tbPackage.setOrginalPrice(priceString);
			tbPackage.setCurrentPrice(priceCurrent);
			tbPackage.setDetailInfo(infoString);
			tbPackage.setPackageName(packageName);
			tbPackage.setCreateTime(time);
			getMySession().save(tbPackage);

			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}

	// 查询套餐
	public List<TbPackage> packageQuery(Integer pcId) {
		// TODO Auto-generated method stub
		List<TbPackage> list = null;
		try {
			String queryString = "from TbPackage tp where tp.id=" + pcId;
			Query query = getMySession().createQuery(queryString);
			// query.setParameter("pid", pcId);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	// 删除套餐
	@Override
	public String packageDelete(Integer pcId) {
		// TODO Auto-generated method stub
		try {
			System.out.println(pcId);
			String queryString = "delete   TbPackage tp where id=" + pcId;
			Query query = getMySession().createQuery(queryString);
			// query.setInteger("pid", pcId);
			query.executeUpdate();
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}
	@Override
	public String packageUpdate(Integer pcId, String priceString,
			String currentPriceString, String infoString, String packageName) {
		// TODO Auto-generated method stub
		try {
			Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//			String queryString = "update TbPackage set orginalPrice="+priceString+" and "+
//			     "currentPrice="+currentPriceString+" and "+ "detailInfo="+infoString+" and "+"packageName="+
//			     packageName+" and "+"createTime="+timestamp+" where id="+pcId;
			String queryString="update TbPackage set orginalPrice=:orginalPrice , currentPrice=:currentPrice , detailInfo=:detailInfo ,packageName=:packageName ,createTime=:createTime where id=:id";
			Query query=getMySession().createQuery(queryString);
			query.setParameter("orginalPrice", priceString);
			query.setParameter("currentPrice", currentPriceString);
			query.setParameter("detailInfo", infoString);
			query.setParameter("packageName", packageName);
			query.setParameter("createTime", timestamp);
			query.setParameter("id", pcId);
			
			System.out.println(query.getQueryString());
			query.executeUpdate();
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	
	}
}
