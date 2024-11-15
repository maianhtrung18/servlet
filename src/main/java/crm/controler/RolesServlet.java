package crm.controler;

import java.io.IOException;
import java.util.Iterator;

import crm.model.Roles;
import crm.service.RolesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="roleServlet", urlPatterns = {"/roles"})
public class RolesServlet extends HttpServlet{
	
	private RolesService rolesService = new RolesService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", rolesService.getRoles());
//		for(Roles role: rolesService.getRoles()) {
//			System.out.print(role.getId());
//			System.out.print(role.getRoleName());
//			System.out.println(role.getDescription());
//		}
		req.getRequestDispatcher("/role-table.jsp").forward(req, resp);
	}
}
