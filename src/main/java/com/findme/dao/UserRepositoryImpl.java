package com.findme.dao;

import com.findme.exception.BadRequestException;
import com.findme.exception.InternalServerError;
import com.findme.exception.NotFoundException;
import com.findme.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    private static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER_SOCIAL WHERE PHONE = ?" +
            " AND USER_PASSWORD = ?";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User delete(Long id) {
        User user = findById(id);
        entityManager.detach(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User userLogin(String login, String password) {
        Query query = entityManager.createNativeQuery(FIND_USER_BY_LOGIN_AND_PASSWORD, User.class);
        query.setParameter(1, login);
        query.setParameter(2, password);
        User user = (User) query.getSingleResult();
        return user;
    }
}
