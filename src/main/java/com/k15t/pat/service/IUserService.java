package com.k15t.pat.service;

import com.k15t.pat.exception.InvalidTokenException;
import com.k15t.pat.exception.UserAlreadyExistsException;
import com.k15t.pat.jpa.data.User;
import com.k15t.pat.web.data.UserData;

public interface IUserService {
	User register(final UserData user) throws UserAlreadyExistsException;

	boolean checkIfUserExist(final String email);

	void sendRegistrationConfirmationEmail(final User user);

	boolean verifyUser(final String token) throws InvalidTokenException;
}
