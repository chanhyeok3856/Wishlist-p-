package chan.wishlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistDeleteAllController implements Controller {
    private static Log log = LogFactory.getLog(WishlistDeleteAllController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("WishlistDeleteAllController 실행");
        
        WishlistDAO wishlistDAO = new WishlistDAO();
        WishlistDTO wishlistDTO = wishlistDAO.wishlistDeleteAll(new WishlistDTO());
        // DTO 값이 있는지 확인
        if (wishlistDTO != null) {
            request.setAttribute("wishlistDTO", wishlistDTO);
            HandlerAdapter handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/wishlist_delete_all.jsp");
            return handlerAdapter;
        } else {
            // DTO 값이 없으면 실패 JSP로 이동
            HandlerAdapter handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/wishlist_delete_fail.jsp");
            return handlerAdapter;
        }
    }
}