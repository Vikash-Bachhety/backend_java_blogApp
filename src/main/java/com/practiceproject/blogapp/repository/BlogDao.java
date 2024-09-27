package com.practiceproject.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceproject.blogapp.entity.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog, Long> {
}
