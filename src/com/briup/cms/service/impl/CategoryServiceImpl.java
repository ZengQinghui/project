package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Category;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.service.ICategoryService;
/*
 * 栏目管理 业务逻辑层的实现类
 */
public class CategoryServiceImpl implements ICategoryService {
	//创建Dao层对象，方便Service层的各个方法调用dao层的方法
	private CategoryDao categoryDao=new CategoryDao();
	@Override
	public void add(Category category) {
			categoryDao.save(category);	
	}
	
	@Override
	public List<Category> list() {
		return categoryDao.findAll();
	}
	
	@Override
	public void delete(long id) {
		categoryDao.deleteById(id);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

}
