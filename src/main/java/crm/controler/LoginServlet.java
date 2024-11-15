package crm.controler;

import java.io.IOException;

import crm.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  username = req.getParameter("username");
		String  password = req.getParameter("password");
		
		
		boolean isLogin = loginService.checkLogin(username, password);
		System.out.print(isLogin);
	}

}
