package crm.reopsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MySqlConnection;
import crm.model.User;

public class UserRepository {
	public List<User> getUserByUsernameAndPassword(String username, String password) {
		
		List<User> list = new ArrayList<>();
		Connection connection = MySqlConnection.getConnection();
		String  query = "select * from users where username=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user  = new User();
				user.setId(resultSet.getInt("id"));
				user.setFullname(resultSet.getString("fullname"));
				user.setAge(resultSet.getInt("age"));
				user.setCreatted_date(resultSet.getString("created_date"));
				user.setUsername(resultSet.getString("username"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;	
	}
}
