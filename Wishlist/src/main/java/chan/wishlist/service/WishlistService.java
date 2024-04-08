package chan.wishlist.service;

import java.util.ArrayList;

import chan.wishlist.dto.WishlistDTO;

public interface WishlistService {
	public ArrayList<WishlistDTO> wishlistSelectAll(int page, int limit);
	public WishlistDTO wishlistInsert(WishlistDTO wishlistDTO);
	public WishlistDTO wishlistSelect(WishlistDTO wishlistDTO);
	public WishlistDTO wishlistDelete(WishlistDTO wishlistDTO);
	public int wishlistCount();
	

}
