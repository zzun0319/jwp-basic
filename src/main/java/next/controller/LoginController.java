package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

//@WebServlet(value = { "/users/login", "/users/loginForm" })
public class LoginController implements Controller {

    protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
        return "/user/login.jsp";
    }

    protected String doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }

        if (user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            return "redirect:/";
        } else {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String result;
		String method = request.getMethod();
		if(method.equals("GET")) {
			result = doGet(request, response);
		} else {
			result = doPost(request, response);
		}
		return result;
	}
}
