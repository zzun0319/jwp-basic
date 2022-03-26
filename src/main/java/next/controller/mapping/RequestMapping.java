package next.controller.mapping;

import java.util.HashMap;
import java.util.Map;

import next.controller.Controller;
import next.controller.CreateUserController;
import next.controller.HomeController;
import next.controller.ListUserController;
import next.controller.LoginController;
import next.controller.LogoutController;
import next.controller.ProfileController;
import next.controller.UpdateUserController;

public class RequestMapping {
	
	public static Map<String, Controller> controllers = new HashMap<String, Controller>();

	static {
		
		Controller updateController = new UpdateUserController();
		controllers.put("/users/update", updateController);
		controllers.put("/users/updateForm", updateController);
		controllers.put("/users/profile", new ProfileController());
		controllers.put("/users/logout", new LogoutController());
		Controller loginController = new LoginController();
		controllers.put("/users/login", loginController);
		controllers.put("/users/loginForm", loginController);
		controllers.put("/users", new ListUserController());
		Controller homeContoller = new HomeController();
		controllers.put("/", homeContoller);
		controllers.put("/home", homeContoller);
		Controller createUserController = new CreateUserController();
		controllers.put("/users/create", createUserController);
		controllers.put("/users/form", createUserController);
	}
	
	public static Controller getController(String url) {
		Controller controller = controllers.get(url);
		if(controller == null) {
			return controllers.get("/home");
		} else {
			return controller;
		}
	}
}
