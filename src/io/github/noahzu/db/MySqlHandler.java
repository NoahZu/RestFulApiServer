package io.github.noahzu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.noahzu.entity.User;

public class MySqlHandler {
	/**
	 * 用户登录
	 * @param user
	 * @return 登录成功返回User，失败返回null
	 */
	public User userLogin(User user){
		Connection conn = null;
		try {
			conn = MySqlConnection.getInstance().getCon();
			String sql = "select * from user where userName = ? and passWord = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.userName);
			pstmt.setString(2, user.passWord);
			ResultSet result = pstmt.executeQuery();
			if(result.next()){
				user.shortIntroduce = result.getString(result.findColumn("shortIntroduce"));
				user.iconUrl = result.getString(result.findColumn("iconUrl"));
				return user;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null){
				try {
					MySqlConnection.getInstance().closeCon(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	/**
	 * 用户注册
	 * @param user
	 * @return 成功返回user，失败返回null
	 */
	public User userRegis(User user){
		Connection conn = null;
		user.shortIntroduce = "该用户没有任何介绍";
		user.iconUrl = "default";
		try {
			conn = MySqlConnection.getInstance().getCon();
			String sql = "insert into user values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.userName);
			pstmt.setString(2, user.passWord);
			pstmt.setString(3, user.shortIntroduce);
			pstmt.setString(4, user.iconUrl);
			pstmt.execute();
			return user;
		} catch (Exception e) {
			return null;
		}
		finally{
			if(conn != null){
				try {
					MySqlConnection.getInstance().closeCon(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
	}
}
