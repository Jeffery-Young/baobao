package com.shijing.service;

import java.util.List;

import com.shijing.bean.TbComment;

public interface CommentManager {

	//�����б�
	List<TbComment> showComment(Integer start, Integer sizeInteger, Integer flag);

	//��������
	Integer sumComment();

	//ɾ������
	String commentDelete(Integer deleteNo);

	//ͨ������
	String commentPass(Integer passNo);


}
