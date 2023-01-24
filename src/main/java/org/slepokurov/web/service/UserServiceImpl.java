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


}
