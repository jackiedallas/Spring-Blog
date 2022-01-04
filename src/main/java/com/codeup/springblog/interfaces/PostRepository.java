package com.codeup.springblog.interfaces;

import com.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findAll();
//    Post findPostById (Long id);
//    Post deleteBy (Long id);
}

