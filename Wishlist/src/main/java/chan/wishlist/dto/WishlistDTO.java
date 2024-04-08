package chan.wishlist.dto;

public class WishlistDTO {
	private int productnum;
	private String productname;
	private String userid;
	public int getProductnum() {
		return productnum;
	}
	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "WishlistDTO [productnum=" + productnum + ", productname=" + productname + ", userid=" + userid + "]";
	}	
	
}
