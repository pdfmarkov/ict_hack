package org.comrades.springtime.servise;

import org.comrades.springtime.customExceptions.PostNotFoundException;
import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {

    List<Post> getPostsByUser(User user) throws PostNotFoundException;

    List<Post> getPosts() throws PostNotFoundException;

    void clearByUser(User user) throws PostNotFoundException;

    Post savePost(Post post) throws PostNotFoundException;

    void deletePost(Long id) throws PostNotFoundException;

    Post findById(Long id) throws PostNotFoundException;

    Post findByTime(LocalDateTime time) throws PostNotFoundException;

}
