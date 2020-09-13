package com.k15t.pat.controller.registration;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.k15t.pat.exception.UserAlreadyExistsException;
import com.k15t.pat.service.UserService;
import com.k15t.pat.web.data.UserData;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messageSource;// Internationalization is not added.
	// But I am adding MessageSource so that in future we can easily add
	// Internationalization if needed

	@GetMapping("/registration")
	public String register(final Model model) {
		model.addAttribute("userData", new UserData());
		return "registration";
	}

	@PostMapping("/registration")
	public String register(final @Valid UserData userData, final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("registrationForm", userData);
			return "registration";
		}
		try {
			userService.register(userData);
		} catch (UserAlreadyExistsException userEX) {
			bindingResult.rejectValue("email", "userData.email", "Account already exists with this email.");
			model.addAttribute("registrationForm", userData);
			return "registration";
		}
		// TODO using hard-coded US to show how to do translation. Adapt it if we want
		// to support Internationalization in future
		model.addAttribute("registrationMsg", messageSource.getMessage("registration.success", null, Locale.US));
		return "registration";
	}
}
