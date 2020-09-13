package com.k15t.pat.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.k15t.pat.exception.UserAlreadyExistsException;
import com.k15t.pat.jpa.data.User;
import com.k15t.pat.jpa.repository.UserRepository;
import com.k15t.pat.util.Util;
import com.k15t.pat.web.data.UserData;

@ExtendWith(MockitoExtension.class)
public class UnitTestUserService {
	@Mock
	private UserRepository userRepository;
	@Mock
	PasswordEncoder passwordEncoder;
	@InjectMocks
	private UserService userService;

	@Test
	void register() throws UserAlreadyExistsException {
		UserData userData = Util.INSTANCE.getCorrectUserData();
		when(userRepository.save(isA(User.class))).then(returnsFirstArg());
		User registeredUser = userService.register(userData);
		assertTrue(registeredUser.getEmail().equals(userData.getEmail()));
	}

	@Test
	void duplicateEmailTest() throws UserAlreadyExistsException {
		UserData userData = Util.INSTANCE.getCorrectUserData();
		when(userRepository.findByEmail(userData.getEmail())).thenReturn(new User());
		assertThrows(UserAlreadyExistsException.class, () -> userService.register(userData));
		verify(userRepository, never()).save(isA(User.class));
	}
}
