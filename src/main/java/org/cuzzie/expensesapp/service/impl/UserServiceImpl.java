package org.cuzzie.expensesapp.service.impl;

import org.cuzzie.expensesapp.model.User;
import org.cuzzie.expensesapp.repository.UserRepository;
import org.cuzzie.expensesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cuzzie on 6/15/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }
}
