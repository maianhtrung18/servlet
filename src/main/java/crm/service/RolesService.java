package crm.service;

import java.util.List;

import crm.model.Roles;
import crm.reopsitory.RolesRepository;

public class RolesService {
	private RolesRepository repository = new  RolesRepository();
	
	public List<Roles> getRoles() {
		return  repository.getRoles();
	}
	
	public boolean deleteRoleById(int id) {
		return repository.deleteRoleById(id) > 0 ? true : false; 		
	}
	
	public boolean insertRole(String roleName, String description) {
		return repository.insertRole(roleName, description) > 0 ;	
	}
}
