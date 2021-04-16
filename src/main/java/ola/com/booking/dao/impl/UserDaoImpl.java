package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn = ConectionManager.getConnection();

	@Override
	public void saveUser(User user) {
		System.out.println("" + user.getuserId());
		try {
			PreparedStatement stmt = conn
					.prepareStatement("insert into User_r (email, name, password, phoneNo) values (?,?,?,?)");
			// stmt.setInt(1, user.getuserId());
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getPhoneNo());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User validateUser(String username, String password) {
		User u = new User();
		try {
			ResultSet rs = null;
			PreparedStatement stmt = conn
					.prepareStatement("SELECT userId,name,password FROM User_r WHERE name=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while (rs.next()) {
				u.setId(rs.getInt("userId"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
