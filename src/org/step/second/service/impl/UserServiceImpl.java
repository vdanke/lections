package org.step.second.service.impl;

import org.step.second.model.User;
import org.step.second.repository.PersonRepository;
import org.step.second.repository.impl.UserRepositoryImpl;
import org.step.second.service.UserService;

import java.util.Collections;
import java.util.List;

import static org.step.second.data.UserData.EMPTY_USER;

public class UserServiceImpl implements UserService<User> {

    private PersonRepository<User> personRepository = new UserRepositoryImpl();
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public User findById(Long id) {
        if (id == null) {
            return EMPTY_USER;
        }
        return personRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        if (username == null || username.length() == 0) {
            return EMPTY_USER;
        }
        return personRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        if (user == null) {
            return EMPTY_USER;
        }
        if (user.getUsername() == null || user.getPassword() == null) {
            return EMPTY_USER;
        }
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return EMPTY_USER;
        }
        return personRepository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> userList) {
        if (userList == null || userList.isEmpty()) {
            return Collections.emptyList();
        }
        return personRepository.saveAll(userList);
    }

    public User saveOldUser(User user) {
        return userRepository.saveUser(user);
    }
}
