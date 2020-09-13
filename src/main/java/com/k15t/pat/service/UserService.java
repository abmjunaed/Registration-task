package com.k15t.pat.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.k15t.pat.exception.InvalidTokenException;
import com.k15t.pat.exception.UserAlreadyExistsException;
import com.k15t.pat.jpa.data.User;
import com.k15t.pat.jpa.repository.UserRepository;
import com.k15t.pat.web.data.UserData;

@Service
public class UserService implements IUserService {
	private UserRepository userRepository;
	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User register(UserData userData) throws UserAlreadyExistsException {

		// Let's check if user already registered with us
		if (checkIfUserExist(userData.getEmail())) {
			throw new UserAlreadyExistsException("User already exists for this email");
		}
		User userEntity = new User();
		BeanUtils.copyProperties(userData, userEntity);
		encodePassword(userEntity, userData);
		return userRepository.save(userEntity);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	private void encodePassword(User userEntity, UserData user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	@Override
	public void sendRegistrationConfirmationEmail(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyUser(String token) throws InvalidTokenException {
		// TODO Auto-generated method stub
		return false;
	}
}
