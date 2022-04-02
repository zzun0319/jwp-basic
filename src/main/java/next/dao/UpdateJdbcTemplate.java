package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.jdbc.ConnectionManager;
import next.model.User;

public abstract class UpdateJdbcTemplate {

	public void update(User user) throws SQLException {
        // TODO 구현 필요함.
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		
    		con = ConnectionManager.getConnection();
    		String sql = createQueryForUpdate();
    		pstmt = con.prepareStatement(sql);
    		setValuesForUpdate(user, pstmt);
    		
    		pstmt.executeUpdate();
    		
    	} finally {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
		}
    	
    }
	
	public abstract String createQueryForUpdate();
	
	public abstract void setValuesForUpdate(User user, PreparedStatement pstmt) throws SQLException;
	
}
