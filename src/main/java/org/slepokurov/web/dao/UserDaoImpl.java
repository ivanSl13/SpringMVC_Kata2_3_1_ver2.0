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

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getOneUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updatUser(int id, User user) {
        User userUpdate = getOneUser(id);
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getOneUser(id));
    }

}
