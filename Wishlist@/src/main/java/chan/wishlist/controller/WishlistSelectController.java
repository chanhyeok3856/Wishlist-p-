package chan.wishlist.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistSelectController implements Controller {
	private static final Log log = LogFactory.getLog(WishlistSelectController.class);
@Override
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
WishlistDAO wishlistDAO = new WishlistDAO();
ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>();
}
}