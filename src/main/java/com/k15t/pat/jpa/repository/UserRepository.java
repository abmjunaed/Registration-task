package com.k15t.pat.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k15t.pat.jpa.data.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
