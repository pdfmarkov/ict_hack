package org.comrades.springtime.dao;

import lombok.NonNull;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.TablePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUser(User user);

    @Transactional
    //TODO: ПЕРЕДЕЛАЙ
    @Query(value = "select p.title, p.text, p.time from posts p", nativeQuery = true)
    @NonNull
    List<Post> getPostBy();

    Post getPostById(Long id);

    Post findPostByTime(LocalDateTime time);
}
