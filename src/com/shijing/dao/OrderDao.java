package com.shijing.dao;

import java.util.List;

import com.shijing.bean.TbOrderdetail;


public interface OrderDao {

	//��ȡ�����б�
	List<TbOrderdetail> getOrderList(Integer page, Integer pageSize);

	//��������
	List<TbOrderdetail> searchOrder(Integer pageSize, Integer flag, String searchWord);

	//ɾ������
	String orderDelete(Integer oId);


}
