package org.step.second.repository.impl;

import org.step.second.data.UserData;
import org.step.second.exceptions.WrongDataCheckedException;
import org.step.second.exceptions.WrongDataException;
import org.step.second.model.User;
import org.step.second.repository.PersonRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.step.second.data.UserData.EMPTY_USER;

public class UserRepositoryImpl implements PersonRepository<User> {

    private UserData userData = new UserData();

    @Override
    public User findById(Long id) {
        boolean isIdExists = UserData.getUserMapById().containsKey(id);

        if (!isIdExists) {
            throw new WrongDataException("User id not found");
        }
        return userData.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        boolean isUsernameExists = UserData.getUserMapByUsername().containsKey(username);

        try {
            if (!isUsernameExists) {
                throw new WrongDataCheckedException("Username not found");
            }
        } catch (WrongDataCheckedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("User not found");
        }
        return userData.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userData.save(user);
    }

    @Deprecated
    public User saveUser(User user) {
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> saveAll(List<User> userList) {
        return (List<User>) userData.saveAll(userList);
    }
}
