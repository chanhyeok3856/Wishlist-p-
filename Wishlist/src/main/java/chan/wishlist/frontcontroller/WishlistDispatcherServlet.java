package chan.wishlist.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.controller.WishlistSelectController;
import chan.wishlist.hander.HandlerAdapter;



@WebServlet("/WishlistDispatcherServlet")
public class WishlistDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(WishlistDispatcherServlet.class);
	private static final long serialVersionUID = 1L;

       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);

	}
	
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String requestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	String pathURI = requestURI.substring(contextPath.length());
	HandlerAdapter handlerAdapter = null;
	Controller controller = null;
	if (pathURI.equals("/WishlistSelect.wi")) {
		controller = new WishlistSelectController();
		handlerAdapter = controller.execute(request, response);
		log.info("찜 목록 전체 조회 확인 - "+handlerAdapter);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
		dispatcher.forward(request, response);
	}
	
}

}
