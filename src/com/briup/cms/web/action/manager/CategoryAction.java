package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 后台栏目管理Action
 *
 */
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//同名参数传值
	private String name;
	private Integer code;
	
	//创建Service层的对象，方便action各个方法去调用
	private ICategoryService categoryService=new CategoryServiceImpl();
	
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
		//将接收到的参数进行封装，封装为一个对象
		Category category =new Category(name,code);
		//调用service层的服务，完成添加栏目的功能
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
