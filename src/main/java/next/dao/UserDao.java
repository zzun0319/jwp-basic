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
    	
        MyJdbcTemplate template = new MyJdbcTemplate() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getEmail());
			}
			
//			@Override
//			public String createQuery() {
//				String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
//				return sql;
//			}
		};
		
		template.update2("INSERT INTO USERS VALUES (?, ?, ?, ?)");
    }

    public void update(User user) throws SQLException {
        
    	MyJdbcTemplate template = new MyJdbcTemplate() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getUserId());
			}
			
//			@Override
//			public String createQuery() {
//				String sql = "UPDATE users SET password=?,name=?,email=? WHERE userId=?";
//				return sql;
//			}
		};
		
		template.update2("UPDATE users SET password=?,name=?,email=? WHERE userId=?");
    	
    }

    public List<User> findAll() throws SQLException {
        
    	SelectJdbcTemplate template = new SelectJdbcTemplate() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
			}
			
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				while(rs.next()) {
					users.add(new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
                        rs.getString("email")));
				}
				return users;
			}
		};
		
		return (List<User>)template.query("SELECT * FROM users");
    	
    }

    public User findByUserId(String userId) throws SQLException {
        
    	SelectJdbcTemplate template = new SelectJdbcTemplate() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				
				pstmt.setString(1, userId);
			}
			
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				
				User user = null;
				
				while(rs.next()) {
					user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
				}
				return user;
			}
		};
		
		return (User)template.queryForObject("SELECT * FROM users WHERE userId=?");
    	
    }
}
