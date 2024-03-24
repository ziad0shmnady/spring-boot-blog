package com.boot.jpa.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    // User findByEmailAndPassword(String email, String password);
}
