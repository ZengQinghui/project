package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.common.ConnectionFactory;

public class ArticleDao {
	/*
	 * 修改
	 */
	public void update(Article article){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1.注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="UPDATE t_article SET title = ?, author = ?,content=?,publisurDate=? WHERE id = ?";
				//2.预处理sql
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setString(3, article.getContent());
				pstmt.setDate(4, new Date(article.getPublisurDate().getTime()));
				pstmt.setLong(5, article.getId());
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
				String sql="delete from t_article where id=?";
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
	 * 查询所有
	 * @return
	 */
	public List<Article> findAll(){
		List<Article> list = new ArrayList<Article>();
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					Date date = rs.getDate("publisurDate");
					int clickTimes = rs.getInt("clickTimes");
					long c_id = rs.getLong("c_id");
					
					Article article = new Article(title, author, content, clickTimes, c_id);
					article.setId(id);
					article.setPublisurDate(date);	
					list.add(article);
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
	 * @param  文章
	 * */
	public void save(Article article){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_article(title,content,author"
						+ ",publisurDate,clickTimes,c_id) values(?,?,?,?,?,?)";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getContent());
				pstmt.setString(3, article.getAuthor());
				pstmt.setDate(4, new Date(article.getPublisurDate().getTime()));
				pstmt.setInt(5, article.getClickTimes());
				pstmt.setLong(6, article.getC_id());
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
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
	}
}
