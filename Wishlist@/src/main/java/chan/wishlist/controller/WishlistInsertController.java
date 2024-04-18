package chan.wishlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistInsertController implements Controller {
private static Log log = LogFactory.getLog(WishlistInsertController.class);

@Override
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
WishlistDTO wishlistDTO = new WishlistDTO();
WishlistDAO wishlistDAO = new WishlistDAO();
//int product_number = productDAO.productnumber(); [상품 담당자 테이블과 연동해야함!]
HandlerAdapter handlerAdapter = new HandlerAdapter();
return handlerAdapter;
}
}
