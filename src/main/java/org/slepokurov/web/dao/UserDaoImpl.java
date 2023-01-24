package org.slepokurov.web.dao;

import org.slepokurov.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
      TypedQuery<User> queue = entityManager.createQuery("SELECT u FROM User u", User.class);
        return queue.getResultList();
    }

//"SELECT u FROM User u",
}
