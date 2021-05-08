package org.comrades.springtime.servise;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {

    List<Post> getPostsByUser(User user);

    List<Post> getPosts();

    void clearByUser(User user);

    Post savePost(Post post);

    void deletePost(Long id);

    Post findById(Long id);

    Post findByTime(LocalDateTime time);

}
