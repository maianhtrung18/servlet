package crm.service;

import java.util.List;

import crm.model.User;
import crm.reopsitory.UserRepository;

public class LoginService {
	private UserRepository userRepository = new UserRepository();
	public boolean checkLogin(String username, String password) {

		List<User> list = userRepository.getUserByUsernameAndPassword(username, password);
		if (list.size()==1) {
			return true;
		}
		return false;
	}
}
