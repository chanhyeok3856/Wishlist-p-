package chan.wishlist.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chan.wishlist.control.Controller;
import chan.wishlist.hander.HandlerAdapter;



public class WishlistDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);
	}
protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	String requestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	String pathURI = requestURI.substring(contextPath.length());
	HandlerAdapter handlerAdapter = new HandlerAdapter();
	Controller controller = null;
	if (pathURI.equals("/WishlistSelect.wi")) {
		controller = new WishlistSelectController();
		handlerAdapter = controller.execute(request, response);
	}
}
}
