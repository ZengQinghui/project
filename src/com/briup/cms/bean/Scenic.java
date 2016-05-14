package com.briup.cms.bean;

public class Scenic {
	private Long id;
	private String name;
	private String site;
	private String describe;
	private Double price;
	
	public Scenic(){
		
	}

	public Scenic(String name, String site, String describe, Double price) {
		super();
		this.name = name;
		this.site = site;
		this.describe = describe;
		this.price =  price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
