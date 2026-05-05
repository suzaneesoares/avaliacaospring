package com.projetoLoginSuzane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLoginSuzane.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByUsername(String username);
}
