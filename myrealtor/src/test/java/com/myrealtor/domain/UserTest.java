
package com.myrealtor.domain;

import com.myrealtor.BasicTest;

public class UserTest {
	
	public static User create() {
		User c = new User();
		c.setUsername("TEST1234");
		c.setLastName("Test");
		c.setFirstName("Test");
		c.setEmail("test@email.com");
		c.setPassword("1234");
		c.setEnabled((short) 1);
		return c;
	}

	

	public static User insert() {
		return (User) BasicTest.insert(create());
	}

}
