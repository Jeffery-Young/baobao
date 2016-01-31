package com.shijing.service;

import java.util.List;

import com.shijing.bean.TbPackage;

public interface PackageManager {

	// ��ȡ�����ײ�
	List<TbPackage> getPackageList();

	// ����ײ�
	String addPackage(String packageName,String priceString, String priceCurrent, String infoString);

	// ��ѯ�ײ�
	List<TbPackage> queryPackage(Integer pcId);

	// ɾ���ײ�
	String deletePackage(Integer pcId);

	// �����ײ�
	String updatePacekage(Integer pcId, String priceString,
			String currentPriceString, String infoString, String packageName);

}
