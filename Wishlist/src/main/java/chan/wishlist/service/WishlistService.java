package chan.wishlist.service;

import java.util.ArrayList;

import chan.wishlist.dto.WishlistDTO;

public interface WishlistService {
	public ArrayList<WishlistDTO> wishlistSelectAll(int page, int limit);// 여기 int랑 limit 도 수정해야함 왜쓰는지 이해!!
	
	public WishlistDTO wishlistInsert(WishlistDTO wishlistDTO);
	public WishlistDTO wishlistSelect(WishlistDTO wishlistDTO);
	
	public int wishlistCount();
	boolean wishlistDelete(int num);
	

}
