package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}