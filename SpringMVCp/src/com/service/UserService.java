package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Statement;
import com.pojo.tb_users;
import com.utils.DBUtil;

@Service
public class UserService implements UserServiceImpl {

	Statement st;
	ResultSet rs;
	Connection conn = DBUtil.getConn();

	@Override
	public boolean userlogin(tb_users userS) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_users WHERE user_name=? and user_pass=?");
			st.setString(1, userS.getUser_name());

			st.setString(2, userS.getUser_pass());

			rs = st.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean userrigister(tb_users userS) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st = conn.prepareStatement("insert into tb_users(user_name,user_pass) values(?,?)");
			st.setString(1, userS.getUser_name());
			st.setString(2, userS.getUser_pass());
			int rs = st.executeUpdate();
			if (rs>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean userchange(tb_users userS) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st = conn.prepareStatement("UPDATE tb_users SET user_pass=? WHERE user_name=?");
			st.setString(1, userS.getUser_name());
			st.setString(2, userS.getUser_pass());
			int rs = st.executeUpdate();
			if (rs>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
