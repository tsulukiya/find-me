package com.findme.dao;

import com.findme.models.Post;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post save(Post post) {
        entityManager.persist(post);
        return post;
    }

    @Override
    public Post update(Post post) {
        entityManager.persist(post);
        return post;
    }

    @Override
    public Post delete(Long id) {
        Post post = findById(id);
        entityManager.detach(post);
        return post;
    }

    @Override
    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }
}
