package org.comrades.springtime.servise.impl;

import org.comrades.springtime.dao.PostRepository;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;
import org.comrades.springtime.servise.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {this.postRepository = postRepository; }

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepository.findPostsByUser(user);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public void clearByUser(User user) {
//        return dotRepository.deleteAllByUser(user);
        for(Post post : user.getPostList()) {
            postRepository.delete(post);
//            dotRepository.removeByDotId(dot.getDotId());
        }
    }


    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
