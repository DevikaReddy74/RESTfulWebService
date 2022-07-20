package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
