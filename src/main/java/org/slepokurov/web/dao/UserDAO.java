package org.slepokurov.web.dao;

import org.slepokurov.web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
}
