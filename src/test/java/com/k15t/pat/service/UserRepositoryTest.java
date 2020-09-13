package com.k15t.pat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.k15t.pat.jpa.data.Address;
import com.k15t.pat.jpa.data.User;
import com.k15t.pat.jpa.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	void emptyDB() {
		assertTrue(userRepository.findAll().size() == 0);
	}

	@Test
	void saveNewUser() {
		userRepository.save(getDummyUser());
		assertTrue(userRepository.findAll().size() == 1);
		assertNotNull(userRepository.findByEmail(getDummyUser().getEmail()));
	}

	private User getDummyUser() {
		User user = new User();
		user.setFirstName("First name");
		user.setLastName("Last name");
		user.setPassword("Password");
		user.setEmail("a@b.com");
		Address userAddress = new Address();
		userAddress.setStreet("street");
		userAddress.setHouseNumber("houseNumber");
		userAddress.setZip("zip");
		userAddress.setArea("area");
		userAddress.setCountry("DE");
		user.setAddress(userAddress);
		return user;
	}
}
