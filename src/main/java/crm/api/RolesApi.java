package crm.api;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import crm.common.Constant;
import crm.payload.ResponseData;
import crm.service.RolesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "roleApi", urlPatterns = { Constant.URL_ROLE_DELlETE, Constant.URL_ROLE_ADD })
public class RolesApi extends HttpServlet {

	private RolesService rolesService = new RolesService();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		String urlPath = req.getServletPath();
		switch (urlPath) {
		case Constant.URL_ROLE_DELlETE:
			deleteRoles(req, resp);
			break;
		case Constant.URL_ROLE_ADD:
			addRoles(req, resp);
			break;
		}
			
	}
	
	private void deleteRoles (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")); 	
		boolean isSuccess = rolesService.deleteRoleById(id);
		ResponseData responseData = new ResponseData();
		responseData.setSuccess(isSuccess);
		responseData.setDescription("");
		responseData.setData("");
		String json = gson.toJson(responseData);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		printWriter.flush();
	}
	
	private void addRoles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String roleName = req.getParameter("roleName");
		String description = req.getParameter("description");
		
		boolean isSuccess = rolesService.insertRole(roleName, description);
		ResponseData responseData = new ResponseData();
		responseData.setSuccess(isSuccess);
		responseData.setDescription("");
		responseData.setData("");
		String json = gson.toJson(responseData);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		printWriter.flush();
	}
}
