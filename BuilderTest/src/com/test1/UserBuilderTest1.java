package com.test1;

import org.junit.Test;

public class UserBuilderTest1 {
	@Test
	public void builderTest() {
		User user = User.builder()
				.name("강감찬")
				.age(25)
				.build();
			System.out.println(user);
	}
}
