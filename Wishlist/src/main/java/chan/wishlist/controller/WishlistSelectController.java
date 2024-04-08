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
	private static final Log log = LogFactory.getLog(WishlistSelectController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		WishlistDAO wishlistDAO = new WishlistDAO();
		ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>();
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit") != null && !request.getParameter("limit").equals("")) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		arrayList = wishlistDAO.wishlistSelectAll(page, limit);
		log.info(arrayList);
		int listCount = wishlistDAO.wishlistCount();
		int maxpage = (int) ((double) listCount / limit + 0.9);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage) {
			endpage = maxpage;
		}
		
		request.setAttribute("arrayList", arrayList);
		request.setAttribute("limit", limit);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("./WEB-INF/view/wishlist_select_view.jsp");
		return handlerAdapter;
	}
}

	


