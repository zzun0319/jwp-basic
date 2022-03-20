package core.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import next.model.User;

public class DataBaseTest {
	
	@Test
	public void editTest() {
		User user = new User("user1", "abc1234", "user1", "user1@naver.com");
		DataBase.addUser(user);
		User user2 = new User("user1", "abc123456", "user1111", "user1111@naver.com");
		DataBase.addUser(user2);
		User findUser = DataBase.findUserById("user1");
		assertEquals("user1111", findUser.getName());
		assertEquals("abc123456", findUser.getPassword());
		assertEquals("user1111@naver.com", findUser.getEmail());
	}

}
