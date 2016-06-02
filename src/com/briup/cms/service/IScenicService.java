package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Scenic;

public interface IScenicService {
	//添加景点信息
	void add(Scenic scenic);
	//删除景点信息
	void delete(long id);
	//显示景点信息
	List<Scenic> list();
	//修改景点信息
	void update(Scenic scenic);
}
