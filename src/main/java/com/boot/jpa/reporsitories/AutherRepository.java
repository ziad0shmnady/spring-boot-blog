package com.boot.jpa.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.jpa.model.Auther;

public interface AutherRepository extends JpaRepository<Auther, Integer> {
    // custom query to search to blog post by title or content
}