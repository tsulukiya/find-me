package com.findme.service;

import com.findme.dao.PostRepository;
import com.findme.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
    }

    @Override
    public Post delete(Long id) {
        return postRepository.delete(id);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }
}
