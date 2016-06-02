package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Scenic;
import com.briup.cms.common.ConnectionFactory;

public class ScenicDao {
	/*
	 * 修改
	 */
	public void update(Scenic scenic){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1.注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="UPDATE t_scenic SET name = ?, site = ?, description=?, openingTime=?, price=? WHERE id = ?";
				//2.预处理sql
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, scenic.getName());
				pstmt.setString(2, scenic.getSite());
				pstmt.setString(3, scenic.getDescription());
				pstmt.setString(4, scenic.getOpeningTime());
				pstmt.setDouble(5, scenic.getPrice());
				pstmt.setLong(6, scenic.getId());
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt .close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 删除方法
	 * @param id
	 */
	public void deleteById(long id){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1.注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="delete from t_scenic where id=?";
				//2.预处理sql
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt .close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有景点信息
	 */
	public List<Scenic> findAll(){
		List<Scenic> list = new ArrayList<Scenic>();
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_scenic";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String name = rs.getString("name");
					String site = rs.getString("site");
					String description = rs.getString("description");
					String openingTime=rs.getString("openingTime");
					Double price=rs.getDouble("price");
					
					Scenic scenic=new Scenic(name, site, description,openingTime,price);
					scenic.setId(id);
					list.add(scenic);
				}
				
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 保存
	 * @param  景点信息
	 * */
	public void save(Scenic scenic) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_scenic (name, site, price, description,openingTime) values ( ?, ?, ?, ?, ?)";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, scenic.getName());
				pstmt.setString(2, scenic.getSite());
				pstmt.setDouble(3, scenic.getPrice());
				pstmt.setString(4, scenic.getDescription());
				pstmt.setString(5, scenic.getOpeningTime());
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
