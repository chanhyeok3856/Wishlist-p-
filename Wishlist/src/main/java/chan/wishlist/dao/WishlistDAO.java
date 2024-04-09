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



public class WishlistDAO implements WishlistService {
	private static final Log log = LogFactory.getLog(WishlistDAO.class);
	@Override
	public ArrayList<WishlistDTO> wishlistSelectAll(int page, int limit) {
		ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>( );
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			// 쿼리문 입력
			String sql = "select * from (select  productnum, productname, userid from (select * ";
			sql += "from wishlist where userid != 'admin' order by productnum desc))";
			sql += " where productnum between " + startrow + " and " + endrow;
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery( );
			while(resultSet.next( )) {
				WishlistDTO wishlistDTO = new WishlistDTO( );
				wishlistDTO.setProductnum(resultSet.getInt("num"));
				wishlistDTO.setProductname(resultSet.getString("name"));
				wishlistDTO.setUserid(resultSet.getString("userid"));
				arrayList.add(wishlistDTO);
				log.info("조회 데이터 확인" + wishlistDTO);
			}
			if(resultSet.getRow( ) == 0) {
				log.info("찜 목록이 없습니다.");
			}
		} catch(Exception e) {
			log.info("전체 찜 목록 조회실패 - " + e);
		} finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch(Exception e) {
				e.printStackTrace( );
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
			String sql = "select productname, productnum, userid from wishlist";
			sql+= "where productnum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, wishlistDTO.getProductnum());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				log.info("아이디 확인 -"+resultSet.getInt("productnum"));
				wishlistDTO.setProductname(resultSet.getString("productname"));
				wishlistDTO.setProductnum(resultSet.getInt("productnum"));
				wishlistDTO.setUserid(resultSet.getString("userid"));
			}
			
		} catch (Exception e) {
			log.info("개별 회원 조회 실패 -"+e);
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		return wishlistDTO;
	}
	@Override
	public WishlistDTO wishlistInsert(WishlistDTO wishlistDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into wishlist(productname, productnum, userid)";
			sql+= " values ( ?,?,? )";
			log.info("SQL -" + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, wishlistDTO.getProductname());
			preparedStatement.setInt(2, wishlistDTO.getProductnum());
			preparedStatement.setString(3, wishlistDTO.getUserid());
			int count = preparedStatement.executeUpdate( );
			log.info("입력 데이터 확인 - " + wishlistDTO);
			if(count > 0) {
				connection.commit( );
				log.info("커밋되었습니다.");
			} else {
				connection.rollback( );
				log.info("롤백되었습니다.");
			}
		} catch(Exception e) {
			log.info("찜 목록 등록 실패 - " + e);
		} finally {
			try {
				connection.close( );
				preparedStatement.close( );
			} catch(Exception e) {
				e.printStackTrace( );
			}
		}
		return wishlistDTO;
	}


	@Override
	public boolean wishlistDelete(int num) {
		int result = 0 ;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "delete from wishlist where productnum=?";
			
			log.info("SQL확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			result = preparedStatement.executeUpdate();
			if (result == 0) {
				return false;
			}
		
			
		} catch(Exception e) {
			log.info("찜 목록 삭제 실패 - " + e);
		} finally {
			try {
				connection.close( );
				preparedStatement.close( );
			} catch(Exception e) {
				e.printStackTrace( );
			}
		}
		return false;
	}

	@Override
	public int wishlistCount() {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select count(*) from wishlist";	//오류 발생 가능성 존재
			//count 는 열이 아니라 함수 
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery( );
			if(resultSet.next( )) {
				i = resultSet.getInt(1);
			}
		} catch(Exception e) {
			log.info("현재 찜 목록 갯수 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );
			} catch(Exception e) {
				e.printStackTrace( );
			}
		}
		return i;
	}

	



}
