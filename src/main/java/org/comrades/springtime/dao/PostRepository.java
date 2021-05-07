package org.comrades.springtime.dao;

import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUser(User user);

    @Modifying
    @Transactional
    //TODO: ПЕРЕДЕЛАЙ
    @Query("select p.title, p.text, p.time from Post p")
    List<Post> findAll();
}
