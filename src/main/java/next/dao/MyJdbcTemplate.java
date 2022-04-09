package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.jdbc.ConnectionManager;

public abstract class MyJdbcTemplate {
	
//public void update() throws SQLException {
//    	
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = createQuery();
//            pstmt = con.prepareStatement(sql);
//            setValues(pstmt);
//
//            pstmt.executeUpdate();
//        } finally {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//        }
//    }

public void update2(String sql) throws SQLException {
	
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(sql);
        setValues(pstmt);

        pstmt.executeUpdate();
    } finally {
        if (pstmt != null) {
            pstmt.close();
        }

        if (con != null) {
            con.close();
        }
    }
}

//public abstract String createQuery();

public abstract void setValues(PreparedStatement pstmt) throws SQLException;

}
