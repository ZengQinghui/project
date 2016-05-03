package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.briup.cms.bean.Category;
import com.briup.cms.common.ConnectionFactory;


public class CategoryDao {
	public void save(Category category){
		Connection conn=ConnectionFactory.getConn();
		String sql="insert into ";
		//PreparedStatement pstm=conn.prepareStatement(sql);
	}
}
