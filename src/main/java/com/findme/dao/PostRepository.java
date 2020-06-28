package com.findme.dao;

import com.findme.models.Post;
import com.findme.models.User;

public interface PostRepository {

    Post save(Post post);

    Post update(Post post);

    Post delete(Long id);

    Post findById(Long id);
}
