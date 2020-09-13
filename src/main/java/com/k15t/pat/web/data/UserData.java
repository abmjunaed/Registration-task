package com.k15t.pat.web.data;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.k15t.pat.validator.ValidEmail;
import com.k15t.pat.validator.ValidName;
import com.k15t.pat.validator.ValidPassword;

@ValidPassword(message = "{registration.validation.password.mismatch}")
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{registration.validation.firstName}")
	@ValidName(message = "{registration.validation.name.should.not.be.number}")
	private String firstName;

	@NotEmpty(message = "{registration.validation.lastName}")
	@ValidName(message = "{registration.validation.name.should.not.be.number}")
	private String lastName;

	@NotEmpty(message = "{registration.validation.email}")
	@ValidEmail(message = "{registration.validation.email}")
	private String email;

	@NotEmpty(message = "{registration.validation.password}")
	@Size(min = 8, max = 16)
	private String password;

	private String matchingPassword;

	@NotEmpty(message = "{registration.validation.lastName}")
	private String street;
	@NotEmpty(message = "{registration.validation.lastName}")
	private String houseNumber;

	private String additional;
	@NotEmpty(message = "{registration.validation.lastName}")
	private String area;
	@NotEmpty(message = "{registration.validation.lastName}")
	private String zip;
	@NotEmpty(message = "{registration.validation.lastName}")
	private String country;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
