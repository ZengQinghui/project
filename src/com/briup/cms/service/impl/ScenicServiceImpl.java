package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Scenic;
import com.briup.cms.dao.ScenicDao;
import com.briup.cms.service.IScenicService;

public class ScenicServiceImpl implements IScenicService {
	private ScenicDao scenicDao=new ScenicDao();
	@Override
	public void add(Scenic scenic) {
		scenicDao.save(scenic);
	}

	@Override
	public void delete(long id) {
		scenicDao.deleteById(id);	
	}

	@Override
	public List<Scenic> list() {
		return scenicDao.findAll();
	}

	@Override
	public void update(Scenic scenic) {
		scenicDao.update(scenic);
	}

}
