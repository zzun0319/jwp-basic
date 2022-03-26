package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

//@WebServlet(value = { "/users/create", "/users/form" })
public class CreateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);

    protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
        return "/user/form.jsp";
    }

    protected String doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
                req.getParameter("email"));
        log.debug("User : {}", user);

        DataBase.addUser(user);

        return "redirect:/";
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		String result;
		if(method.equals("GET")) {
			result = doGet(request, response);
		} else {
			result = doPost(request, response);
		}
		return result;
	}
}
