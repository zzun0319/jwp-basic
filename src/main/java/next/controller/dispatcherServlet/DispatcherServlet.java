package next.controller.dispatcherServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.controller.mapping.RequestMapping;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestUri = req.getRequestURI();
		log.debug("requestUri: {}", requestUri);
		try {
			String result = RequestMapping.getController(requestUri).execute(req, resp);
			if(result.contains("redirect")) {
				int endIdx = result.lastIndexOf(":");
				String redirectLocation = result.substring(endIdx);
				resp.sendRedirect(redirectLocation);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(result);
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
