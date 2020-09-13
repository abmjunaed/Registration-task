package com.k15t.pat.controller.registration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.k15t.pat.util.Util;
import com.k15t.pat.web.data.UserData;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationIntegrationTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void registrationSuccessTest() throws Exception {
		UserData userData = Util.INSTANCE.getCorrectUserData();
		mockMvc.perform(post("/registration").param("firstName", userData.getFirstName())
				.param("lastName", userData.getLastName()).param("password", userData.getPassword())
				.param("matchingPassword", userData.getMatchingPassword()).param("street", userData.getStreet())
				.param("houseNumber", userData.getHouseNumber()).param("zip", userData.getZip())
				.param("area", userData.getArea()).param("additional", userData.getAdditional())
				.param("country", userData.getCountry()).param("phoneNumber", userData.getPhoneNumber())
				.param("email", userData.getEmail()).contentType(MediaType.APPLICATION_FORM_URLENCODED)

		).andExpect(status().isOk()).andExpect(view().name("registration"))
				.andExpect(model().attribute("registrationMsg", "Registration successful!"));
	}

}
