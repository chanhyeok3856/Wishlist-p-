package chan.wishlist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;


@WebServlet("/WishlistInsertController")
public class WishlistInsertController implements Controller {
	private static final Log log = LogFactory.getLog(WishlistInsertController.class);
   

	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response){
		String productname = request.getParameter("productname");
		log.info(productname);
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		log.info(productnum);
		String userid = request.getParameter("userid"); 
		log.info(userid);
		WishlistDTO wishlistDTO = new WishlistDTO();
		WishlistDAO wishlistDAO = new WishlistDAO();
		wishlistDTO.setProductname(productname);
		wishlistDTO.setProductnum(productnum);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/wishlist_insert_view.jsp");
	return handlerAdapter;
	}

}
