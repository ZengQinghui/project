package com.briup.cms.web.action.manager;

import java.util.List;

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
	
	private Long id;
	private String name;
	private String site;
	private String description;
	private String openingTime;
	private Double price;
	private List<Scenic> scenicList;
	
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
		scenicList=scenicService.list();
		return SUCCESS;
	}
	
	@Action("addScenic")
	public void addScenic() {
		Scenic scenic=new Scenic(name, site, description,openingTime, price);
		scenicService.add(scenic);
	}
	
	@Action("delScenic")
	public void delScenic() {
		scenicService.delete(id);
	}
	
	@Action("updScenic")
	public void updScenic() {
		Scenic scenic=new Scenic(name, site, description,openingTime, price);
		scenic.setId(id);
		scenicService.update(scenic);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Scenic> getScenicList() {
		return scenicList;
	}

	public void setScenicList(List<Scenic> scenicList) {
		this.scenicList = scenicList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	
}
