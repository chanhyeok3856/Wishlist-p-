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



public class WishlistInsertController implements Controller {
	private static final Log log = LogFactory.getLog(WishlistInsertController.class);
   
@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response){
	log.info("여기까진돼?");
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
		wishlistDTO.setUserid(userid);
		wishlistDTO = wishlistDAO.wishlistInsert(wishlistDTO);
		request.setAttribute("productname", wishlistDTO.getProductname());
		request.setAttribute("productnum", wishlistDTO.getProductnum());
		request.setAttribute("userid", wishlistDTO.getUserid());
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/wishlist_insert_view.jsp");
	return handlerAdapter;
	}

}
