package com.shijing.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.shijing.bean.TbPackage;
import com.shijing.service.PackageManager;

//�ײ���ز���
public class PackageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //packageManagerע��
	private PackageManager packageManager;
	//�����ѯ���ײ�����
	private List<TbPackage>packageList;
	public List<TbPackage> getPackageList() {
		return packageList;
	}
	public void setPackageManager(PackageManager packageManager) {
		this.packageManager = packageManager;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public void packageList(){
		packageList=packageManager.getPackageList();
		System.out.println(packageList);
	}

	
}
