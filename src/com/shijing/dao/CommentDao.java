package com.shijing.dao;

import java.util.List;

import com.shijing.bean.TbComment;


public interface CommentDao {

	//�����б�
	List<TbComment> commentList(Integer start, Integer sizeInteger, Integer flag);

	//��������
	Integer commentSum();

	//ɾ������
	String deleteComment(Integer deleteNo);

	//ͨ������
	String passComment(Integer passNo);

	
}
