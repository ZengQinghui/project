package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Category;

public interface ICategoryService {
	//添加栏目
	void add(Category category);
	//列出所有栏目
	List<Category> list();
	//删除栏目
	void delete(long id);
	//修改栏目
	void update(Category category, long id);
}
