package com.shijing.service;

import java.util.List;

import com.shijing.bean.TbComment;

public interface BaobaoManager {

	//��ȡ����
	List<TbComment> getComment();

	//�������
	void submitComment(String ordersn, String content);

	

}
