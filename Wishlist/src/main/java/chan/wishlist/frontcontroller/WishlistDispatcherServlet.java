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
import chan.wishlist.controller.WishlistDeleteAllController;
import chan.wishlist.controller.WishlistDeleteController;
import chan.wishlist.controller.WishlistInsertController;
import chan.wishlist.controller.WishlistSelectController;
import chan.wishlist.controller.WishlistSelectDetailController;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;





public class WishlistDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(WishlistDispatcherServlet.class);
	private static final long serialVersionUID = 1L;

       
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);
	}
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	service(request, response);

	}
	
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String requestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	String pathURI = requestURI.substring(contextPath.length());
	HandlerAdapter handlerAdapter = new HandlerAdapter();
	Controller controller = null;
	if (pathURI.equals("/WishlistSelect.wi")) {
		controller = new WishlistSelectController();
		handlerAdapter = controller.execute(request, response);
		log.info("찜 목록 전체 조회 확인 - "+handlerAdapter);
	}else if(pathURI.equals("/WishlistInsert.wi")) {
		controller = new WishlistInsertController( );
		handlerAdapter = controller.execute(request, response);
		log.info("찜 목록 등록 확인 - " + handlerAdapter);
	}else if (pathURI.equals("/WishlistDelete.wi")) {
	    String productnumStr = request.getParameter("productnum");
	    if (productnumStr != null && !productnumStr.isEmpty()) {
	        int productnum = Integer.parseInt(productnumStr);
	        WishlistDTO wishlistDTO = new WishlistDTO();
	        wishlistDTO.setProductnum(productnum);
	        
	        WishlistDAO wishlistDAO = new WishlistDAO();
	        boolean isDeleted = wishlistDAO.wishlistDelete(wishlistDTO);
	        
	        if (handlerAdapter != null) {
	            if (isDeleted) {
	                handlerAdapter.setPath("/WEB-INF/view/wishlist_delete_success.jsp");
	            } else {
	                handlerAdapter.setPath("/WEB-INF/view/wishlist_delete_fail.jsp");
	            }
	        } else {
	            // handlerAdapter가 null일 때의 처리
	            // 예를 들어, 에러 페이지로 리다이렉트 또는 에러 메시지를 출력할 수 있습니다.
	        System.out.println("handleradapter가 null입니다");
	        }
	    } else {
	        if (handlerAdapter != null) {
	            handlerAdapter.setPath("/WEB-INF/view/wishlist_delete_fail.jsp");
	        } else {
	            // handlerAdapter가 null일 때의 처리
	            // 예를 들어, 에러 페이지로 리다이렉트 또는 에러 메시지를 출력할 수 있습니다.
	            response.sendRedirect("/wishlistindex.jsp");
	        }
	    }
	
	
	}else if(pathURI.equals("/WishlistSelectDetail.wi")) {
		controller = new WishlistSelectDetailController( );
		handlerAdapter = controller.execute(request, response);
		log.info("찜 목록 상세 조회 - " + handlerAdapter);
	}
		else if(pathURI.equals("/WishlistInsertView.wi")) {
			handlerAdapter = new HandlerAdapter( );
			handlerAdapter.setPath("/WEB-INF/view/wishlist_insert.jsp");
			log.info("찜 목록 등록 뷰 확인 - " + handlerAdapter);
		
	}else if(pathURI.equals("/WishlistDeleteView.wi")) {
		handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/wishlist_delete.jsp");
		log.info("찜 목록 삭제 뷰 확인 - " + handlerAdapter);
	}else if(pathURI.equals("/WishlistDeleteAll.wi")) {
		controller = new WishlistDeleteAllController( );
			handlerAdapter = controller.execute(request, response);
			
			log.info("찜 목록 삭제 뷰 확인 - " + handlerAdapter);
	
}
	
	if (handlerAdapter != null) {
		if (handlerAdapter.isRedirect()) {
			response.sendRedirect(handlerAdapter.getPath());
		
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
		dispatcher.forward(request, response);
	}
	
}
}
}

