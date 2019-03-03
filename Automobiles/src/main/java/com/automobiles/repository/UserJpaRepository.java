package com.automobiles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobiles.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsermobile(String usermobile);
	public User findByUsermobileAndUserpassword(String usermobile,String userpassword);
}
