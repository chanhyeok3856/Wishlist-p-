
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



public class WishlistSelectDetailController implements Controller {
	private static final Log log = LogFactory.getLog(WishlistSelectDetailController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		log.info(productnum);
		WishlistDTO wishlistDTO = new WishlistDTO( );
		wishlistDTO.setProductnum(productnum);
		WishlistDAO wishlistDAO = new WishlistDAO( );
		wishlistDTO = wishlistDAO.wishlistSelect(wishlistDTO);
		log.info(wishlistDTO);
		request.setAttribute("productname", wishlistDTO.getProductname());
		request.setAttribute("productnum", wishlistDTO.getProductnum());
		request.setAttribute("userid", wishlistDTO.getUserid());
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/wishlist_select_detail_view.jsp");
		return handlerAdapter;
	}



	}
