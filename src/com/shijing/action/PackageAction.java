package com.shijing.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shijing.bean.TbPackage;
import com.shijing.service.PackageManager;

//�ײ���ز���
public class PackageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����request,response����
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	// packageManagerע��
	private PackageManager packageManager;
	// �����ѯ���ײ�����
	private List<TbPackage> packageList;

	private File photoUrl;
	private String photoName;

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public File getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(File photoUrl) {
		this.photoUrl = photoUrl;
	}

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

	// �ײ��б�
	public void packageList() throws IOException {
		packageList = packageManager.getPackageList();
		response = (HttpServletResponse) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		JSONArray jsonArray = JSONArray.fromObject(packageList);
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().print(jsonArray);
	}

	// ����ײ�
	public void packageAdd() throws IOException {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext()
				.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		String priceString = request.getParameter("price");
		String infoString = request.getParameter("info");
		String realpath = request.getServletContext().getRealPath("/images");
		String str = packageManager.addPackage(priceString, infoString,photoName);

		System.out.println(realpath);
		if (photoUrl != null) {
			File savefile = new File(new File(realpath), photoName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(photoUrl, savefile);
			ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");
		}
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().print(str);
	}

	// �����ײ�Id��ѯ�ײ���Ϣ
	public void packageQueryTC() throws IOException {
		request = (HttpServletRequest) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		response = (HttpServletResponse) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		Integer pcId = Integer.parseInt(request.getParameter("pid"));
		packageList = packageManager.queryPackage(pcId);
		JSONArray jsonArray = JSONArray.fromObject(packageList);
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().print(jsonArray);
	}

	// �����ײ�Idɾ���ײ���Ϣ
	public void packageDeleteTc() throws IOException {
		request = (HttpServletRequest) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		Integer pcId = Integer.parseInt(request.getParameter("id"));
		String str = packageManager.deletePackage(pcId);
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().print(str);
	}

	// �޸��ײ���Ϣ
	public void packageUpdate() throws IOException {
		request = (HttpServletRequest) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		Integer pcId = Integer.parseInt(request.getParameter("pid"));
		String priceString = request.getParameter("price");
		String currentPriceString = request.getParameter("currentPrice");
		String infoString = request.getParameter("info");
System.out.println(pcId+"  "+photoName);
		String str = packageManager.updatePacekage(pcId, priceString,
				currentPriceString, infoString, photoName);

		String realpath = request.getServletContext().getRealPath("/images");

		System.out.println(realpath);
		if (photoUrl != null && photoName!=null)  {
			File savefile = new File(new File(realpath), photoName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(photoUrl, savefile);
			ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");
		}

		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().print(str);
	}
}
