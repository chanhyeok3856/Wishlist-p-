package chan.wishlist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
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
	public ArrayList<WishlistDTO> wishlistSelectAll() {
		ArrayList<WishlistDTO> arrayList = new ArrayList<WishlistDTO>( );
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			// 쿼리문 입력
			String sql = "select productname, productnum, userid from wishlist";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery( );
			while(resultSet.next( )) {
				WishlistDTO wishlistDTO = new WishlistDTO( );
				wishlistDTO.setProductname(resultSet.getString("productname"));
				wishlistDTO.setProductnum(resultSet.getInt("productnum"));
				
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
			sql+= " where productnum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, wishlistDTO.getProductnum());
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				log.info("상품 번호 확인 -"+resultSet.getInt("productnum"));
				wishlistDTO.setProductname(resultSet.getString("productname"));
				wishlistDTO.setProductnum(resultSet.getInt("productnum"));
				wishlistDTO.setUserid(resultSet.getString("userid"));
			}
			
		} catch (Exception e) {
			log.info("찜 목록 상세 조회 실패 -"+e);
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
	        String sql = "INSERT INTO wishlist(productname, productnum, userid) VALUES (?, ?, ?)";
	        log.info("SQL - " + sql);
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, wishlistDTO.getProductname());
	        preparedStatement.setInt(2, wishlistDTO.getProductnum());
	        preparedStatement.setString(3, wishlistDTO.getUserid());
	        
	        int count = preparedStatement.executeUpdate();
	        log.info("입력 데이터 확인 - " + wishlistDTO);
	        
	        if(count > 0) {
	            log.info("커밋되었습니다.");
	            connection.commit();
	        } else {
	            log.info("롤백되었습니다.");
	            connection.rollback();
	        }
	    } catch(Exception e) {
	        log.info("찜 목록 등록 실패 - " + e);
	        try {
	            if(connection != null) {
	                connection.rollback();
	            }
	        } catch(SQLException ex) {
	            log.error("롤백 중 에러 발생 - " + ex);
	        }
	    } finally {
	        try {
	            if(preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if(connection != null) {
	                connection.close();
	            }
	        } catch(Exception ex) {
	            log.error("자원 해제 중 에러 발생 - " + ex);
	        }
	    }
	    return wishlistDTO;
	}


	@Override
	public boolean wishlistDelete(WishlistDTO wishlistDTO) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    boolean isDeleted = false;

	    try {
	        Class.forName("oracle.jdbc.OracleDriver");
	        connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
	        
	        String sql = "DELETE FROM wishlist WHERE productnum = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, wishlistDTO.getProductnum());

	        int result = preparedStatement.executeUpdate();

	        if (result > 0) {
	            isDeleted = true;
	        }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return isDeleted;
	}
	@Override
	public WishlistDTO wishlistDeleteAll(WishlistDTO wishlistDTO) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        Context context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = dataSource.getConnection();
	        String sql = "delete from wishlist";
	        
	        log.info("SQL - " + sql);
	        preparedStatement = connection.prepareStatement(sql);
	        
	        int count = preparedStatement.executeUpdate();
	        if(count > 0) {
	            log.info(count + "개의 상품이 삭제되었습니다.");
	            wishlistDTO.setProductnum(count);
	        } else {
	          log.info("삭제할 상품이 없습니다.");
	          wishlistDTO.setProductnum(0);
	        }
	    } catch(Exception e) {
	        log.info("찜 목록 전체 삭제 실패 - " + e);
	    } finally {
	        try {
	            if(preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if(connection != null) {
	                connection.close();
	            }
	        } catch(Exception ex) {
	            log.error("자원 해제 중 에러 발생 - " + ex);
	        }
	    }
	    return wishlistDTO;
	}


}
