package chan.wishlist.service;

import java.util.ArrayList;

import chan.wishlist.dto.WishlistDTO;

public interface WishlistService {
	
	
	public WishlistDTO wishlistInsert(WishlistDTO wishlistDTO);
	
	
	
	
	public boolean wishlistDelete(WishlistDTO wishlistDTO);

	ArrayList<WishlistDTO> wishlistSelectAll();
	WishlistDTO wishlistDeleteAll(WishlistDTO wishlistDTO);





	WishlistDTO wishlistSelect(WishlistDTO wishlistDTO);
	

}
