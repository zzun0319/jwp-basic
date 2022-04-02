package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public class UserDao {
    public void insert(User user) throws SQLException {
    	
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

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

    public void update(User user) throws SQLException {
        // TODO 구현 필요함.
    	
    	Connection con = null;
    	PreparedStatement ps = null;
    	
    	try {
    		
    		con = ConnectionManager.getConnection();
    		String sql = "UPDATE users SET password=?,name=?,email=? WHERE userId=?";
    		ps = con.prepareStatement(sql);
    		ps.setString(1, user.getPassword());
    		ps.setString(2, user.getName());
    		ps.setString(3, user.getEmail());
    		ps.setString(4, user.getUserId());
    		
    		ps.executeUpdate();
    		
    	} finally {
			if(con != null) con.close();
			if(ps != null) ps.close();
		}
    	
    }

    public List<User> findAll() throws SQLException {
        // TODO 구현 필요함.
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	List<User> users = new ArrayList<User>();
    	try {
    		
    		con = ConnectionManager.getConnection();
    		String sql = "SELECT * FROM users";
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			User user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
    			users.add(user);
    		}
    		
    		return users;
    		
    	} finally {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} 
    	
    }

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
                        rs.getString("email"));
            }

            return user;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
