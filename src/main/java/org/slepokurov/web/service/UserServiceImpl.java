package org.slepokurov.web.service;

import org.slepokurov.web.dao.UserDaoImpl;
import org.slepokurov.web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

   @Override
   @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User getOneUser(int id) {
        return userDao.getOneUser(id);
    }

    @Override
    @Transactional
    public void updatUser(int id, User user) {
        userDao.updatUser(id, user);
    }
    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }


}
