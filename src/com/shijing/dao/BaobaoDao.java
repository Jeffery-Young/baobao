package com.shijing.dao;

import java.util.List;

import com.shijing.bean.TbComment;


public interface BaobaoDao {

	//��ȡcomment
	List<TbComment> commentShow();

	//�������
	void commentAdd(String ordersn, String content);

	
}
