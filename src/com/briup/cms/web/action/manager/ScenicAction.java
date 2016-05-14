package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Scenic;
import com.briup.cms.service.IScenicService;
import com.briup.cms.service.impl.ScenicServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ScenicAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private IScenicService scenicService
					=new ScenicServiceImpl();
	
	private String name;
	private String site;
	private String describe;
	private Double price;
	
	@Action(value = "toAddScenic", 
			results = { @Result(name = "success", 
			location = "/WEB-INF/jsp/manager/addScenic.jsp") })
	public String toAddScenic() {
		return SUCCESS;
	}

	@Action(value = "toScenicManager", 
			results = { @Result(name = "success", 
			location = "/WEB-INF/jsp/manager/scenicManager.jsp") })
	public String toScenicManager() {
		return SUCCESS;
	}
	
	@Action("addScenic")
	public void addScenic() {
		Scenic scenic=new Scenic(name, site, describe, price);
		scenicService.add(scenic);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
