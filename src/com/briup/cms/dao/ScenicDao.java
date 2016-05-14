package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.briup.cms.bean.Scenic;
import com.briup.cms.common.ConnectionFactory;

public class ScenicDao {
	/**
	 * 保存
	 * @param  景点信息
	 * */
	public void save(Scenic scenic) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			System.out.println(scenic.getDescribe());
			System.out.println(scenic.getPrice());
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_scenic(name,site,describe,price) values(?,?,?,?)";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, scenic.getName());
				pstmt.setString(2, scenic.getSite());
				pstmt.setString(3, scenic.getDescribe());
				pstmt.setDouble(4, scenic.getPrice());
				;
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
