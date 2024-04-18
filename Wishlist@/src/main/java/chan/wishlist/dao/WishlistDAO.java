package chan.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.service.WishlistService;
@SuppressWarnings("finally")
public class WishlistDAO implements WishlistService{
private static final Log log = LogFactory.getLog(WishlistDAO.class);
@Override
public ArrayList<WishlistDTO> wishlistSelectAll(){
	ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection();
		String sql = "select wishlist_number, product_title, product_number, member_number, wishlist_create from wishlist";
		log.info("SQL - " + sql);
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			WishlistDTO wishlistDTO = new WishlistDTO();
			wishlistDTO.setWishlist_number(resultSet.getInt("wishlist_number"));
			wishlistDTO.setProduct_title(resultSet.getString("product_title"));
			wishlistDTO.setProduct_number(resultSet.getInt("product_number"));
			wishlistDTO.setMember_number(resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_create(resultSet.getString("wishlist_create"));
			arrayList.add(wishlistDTO);
			log.info("조회 데이터를 확인한다 - " +wishlistDTO);
		}
	if (resultSet.getRow() == 0) {
		log.info("찜 목록이 존재하지 않습니다.");
	}	
	} catch (Exception e) {
	log.info("전체 찜 목록 조회 실패 - " +e);
	}finally {
	try {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	return arrayList;
	}

@Override
public WishlistDTO wishlistSelect(WishlistDTO wishlistDTO) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection();
		String sql = "select wishlist_number, product_title, product_number, member_number, wishlist_create from wishlist";
		sql+= " where member_number = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, wishlistDTO.getMember_number());
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			log.info("회원 고유 번호 확인 -" +resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_number(resultSet.getInt("wishlist_number"));
			wishlistDTO.setProduct_title(resultSet.getString("product_title"));
			wishlistDTO.setProduct_number(resultSet.getInt("product_num"));
			wishlistDTO.setMember_number(resultSet.getInt("member_number"));
			wishlistDTO.setWishlist_create(resultSet.getString("wishlist_create"));
		}
	} catch (Exception e) {
		log.info("찜 목록 상세 조회 실패 - " +e);
		e.printStackTrace();
	}finally {
		try {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlistDTO;
	}
}
	@Override
	public WishlistDTO wishlistDelete(WishlistDTO wishlistDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from wishlist";
			sql += " where wishlist_number = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, wishlistDTO.getWishlist_number());
			int count = preparedStatement.executeUpdate();
			if (count>0) {
				connection.commit();
				log.info("커밋되었습니다.");
			}else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		try {
		connection.close();
		preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlistDTO;
}
}
}