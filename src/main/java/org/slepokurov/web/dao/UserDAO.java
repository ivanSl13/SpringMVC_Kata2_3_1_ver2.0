package org.slepokurov.web.dao;

import org.slepokurov.web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    User getOneUser(int id);

    void updatUser(int id, User user);

    void deleteUser(int id);
}
