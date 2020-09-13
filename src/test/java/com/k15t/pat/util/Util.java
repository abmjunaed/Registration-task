package com.k15t.pat.util;

import com.k15t.pat.web.data.UserData;

public enum Util {
	INSTANCE;

	public UserData getCorrectUserData() {
		UserData userData = new UserData();
		userData.setFirstName("First name");
		userData.setLastName("Last name");
		userData.setPassword("Password");
		userData.setMatchingPassword("Password");
		userData.setStreet("street");
		userData.setHouseNumber("houseNumber");
		userData.setZip("zip");
		userData.setArea("area");
		userData.setCountry("DE");
		userData.setEmail("a@b.com");
		return userData;
	}
}
