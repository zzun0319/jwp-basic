package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/edit")
public class EditUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", DataBase.findUserById(req.getParameter("userId")));
		RequestDispatcher rd = req.getRequestDispatcher("/user/update_form.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"), req.getParameter("email"));
		DataBase.addUser(user);
		resp.sendRedirect("/user/list");
	}

}
