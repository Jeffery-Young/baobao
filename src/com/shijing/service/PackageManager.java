package com.shijing.service;

import java.util.List;

import com.shijing.bean.TbPackage;

public interface PackageManager {

	//��ȡ�����ײ�
	List<TbPackage> getPackageList();

	String addPackage(String priceString, String infoString, String photoString);

}
