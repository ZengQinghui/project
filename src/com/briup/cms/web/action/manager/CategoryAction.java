package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceimpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private Integer code;
	
	private ICategoryService categoryService=new CategoryServiceimpl();
	
	/**
	 * 
	 * 跳转到添加栏目页面
	 */
	@Action(value="toAddCategory",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")})
	public String toAddCategory(){
		return SUCCESS;
	}
	/**
	 * 
	 * 跳转到栏目管理页面
	 */
	@Action(value="toCategoryManager",
			results={@Result(name="success",location="/WEB-INF/jsp/manager/CategoryManager.jsp")})
	public String toCategoryManager(){
		return SUCCESS;
	}
	
	@Action(value="addCategory")
	public void addCategory(){
		Category category =new Category(name,code);
		categoryService.add(category);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
