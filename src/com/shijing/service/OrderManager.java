package com.shijing.service;

import java.util.List;

import com.shijing.bean.TbOrderdetail;

public interface OrderManager {

	//��ȡ�����б�
	List<TbOrderdetail> orderList(Integer page, Integer pageSize);

	//��������
	List<TbOrderdetail> orderSearch(Integer pageSize, Integer flag, String searchWord);

	//ɾ���ײ�
	String deleteOrder(Integer oId);

}
