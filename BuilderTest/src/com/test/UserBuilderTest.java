package com.test;

import org.junit.Test;

public class UserBuilderTest {

	@Test
	public void builderTest() {
		User user = User.builder()
						.age(19)
						.name("홍길동")
						.build();
		System.out.println(user);
	}
}
