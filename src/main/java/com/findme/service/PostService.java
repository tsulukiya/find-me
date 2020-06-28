package com.findme.service;

import com.findme.models.Post;

public interface PostService {

    Post save(Post post);

    Post update(Post post);

    Post delete(Long id);

    Post findById(Long id);
}
