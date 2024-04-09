package chan.wishlist.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;


public class WishlistSelectController implements Controller {

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("./WEB-INF/view/wishlist_select_view.jsp");
		return handlerAdapter;
	}
}

	


