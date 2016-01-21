package com.shijing.dao;

import java.util.List;

import com.shijing.bean.TbPackage;

public interface PackageDao {

	// ��ѯ�����ײ�
	List<TbPackage> packageList();

	// ����ײ�
	String packageAdd(String priceString, String infoString, String photoString);

	// ��ѯ�ײ�
	List<TbPackage> packageQuery(Integer pcId);

	// ɾ���ײ�
	String packageDelete(Integer pcId);

	// �����ײ�
	String packageUpdate(Integer pcId, String priceString,
			String currentPriceString, String infoString, String photoUrlString);
}
