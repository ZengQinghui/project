package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Category;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.service.ICategoryService;

public class CategoryServiceimpl implements ICategoryService {
	private CategoryDao categoryDao;
	@Override
	public void add(Category category) {
			categoryDao.save(category);	
	}
	@Override
	public List<Category> list() {
				return null;
	}
	@Override
	public void delete(long id) {
				
	}

}
