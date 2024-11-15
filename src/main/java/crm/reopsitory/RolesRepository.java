package crm.reopsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MySqlConnection;
import crm.model.Roles;

public class RolesRepository {
	public List<Roles> getRoles() {
			List<Roles> list = new ArrayList<>();
			Connection connection = MySqlConnection.getConnection();
			String  query = "select * from roles";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Roles role  = new Roles();
					role.setId(resultSet.getInt("id"));		
					role.setRoleName(resultSet.getString("role_name"));
					role.setDescription(resultSet.getString("description"));
					list.add(role);
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
	
	public int deleteRoleById(int id) {
		Connection connection = MySqlConnection.getConnection();
		String  query = "delete from roles where id = ?";
		int isDelete = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			isDelete = preparedStatement.executeUpdate();
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
		return isDelete;	
	}
	
	public int insertRole(String roleName, String description) {
		Connection connection = MySqlConnection.getConnection();
		String  query = "insert into roles(role_name, description) value (?, ?)";
		int isSuccess = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, roleName);
			preparedStatement.setString(2, description);
		 	isSuccess = preparedStatement.executeUpdate();
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
		return isSuccess;
	}
}
