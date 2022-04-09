package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public abstract class SelectJdbcTemplate {
	
	protected List query(String sql) throws SQLException {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        con = ConnectionManager.getConnection();
	        pstmt = con.prepareStatement(sql);

	        rs = pstmt.executeQuery();
	        Object result =  mapRow(rs);
	        if(result instanceof List) return (List)result;
	        return null;
	        
	        
	    } finally {
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	        if(rs != null) {
	        	rs.close();
	        }
	    }
	    
	}
	
	protected Object queryForObject(String sql) throws SQLException {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        con = ConnectionManager.getConnection();
	        pstmt = con.prepareStatement(sql);
	        setValues(pstmt);

	        rs = pstmt.executeQuery();
	        Object result =  mapRow(rs);
	        if(result instanceof User) return (User)result;
	        return null;
	        
	    } finally {
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	        if(rs != null) {
	        	rs.close();
	        }
	    }
	    
	}
	
	public abstract void setValues(PreparedStatement pstmt) throws SQLException;
	
	public abstract Object mapRow(ResultSet rs) throws SQLException;

}
