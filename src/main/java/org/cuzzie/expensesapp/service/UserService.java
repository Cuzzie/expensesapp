package org.cuzzie.expensesapp.service;

import org.cuzzie.expensesapp.model.User;

import java.util.List;

/**
 * Created by Cuzzie on 6/15/2017.
 */
public interface UserService {

    List<User> findAllUsers();

    void createUser(User user);

}
