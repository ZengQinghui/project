package com.briup.cms.bean;

public class Scenic {
	private Long id;
	private String name;
	private String site;
	private String description;
	private String openingTime;
	private Double price;
	
	public Scenic(){
		
	}
	
	public Scenic(String name, String site, String description,
			String openingTime, Double price) {
		super();
		this.name = name;
		this.site = site;
		this.description = description;
		this.openingTime = openingTime;
		this.price = price;
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

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	
	
}
