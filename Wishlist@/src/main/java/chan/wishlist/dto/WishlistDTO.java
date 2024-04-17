package chan.wishlist.dto;

public class WishlistDTO {
private int wishlist_num;
private String product_name;
private int product_num;
private int member_number;
private String wishlist_create;
public int getWishlist_num() {
	return wishlist_num;
}
public void setWishlist_num(int wishlist_num) {
	this.wishlist_num = wishlist_num;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public int getProduct_num() {
	return product_num;
}
public void setProduct_num(int product_num) {
	this.product_num = product_num;
}
public int getMember_number() {
	return member_number;
}
public void setMember_number(int member_number) {
	this.member_number = member_number;
}
public String getWishlist_create() {
	return wishlist_create;
}
public void setWishlist_create(String wishlist_create) {
	this.wishlist_create = wishlist_create;
}
@Override
public String toString() {
	return "WishlistDTO [wishlist_num=" + wishlist_num + ", product_name=" + product_name + ", product_num="
			+ product_num + ", member_number=" + member_number + ", wishlist_create=" + wishlist_create + "]";
}
}