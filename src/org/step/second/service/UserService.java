package org.step.second.service;

import org.step.second.model.User;

import java.util.List;

public interface UserService<T extends User> {

    T findById(Long id);

    T findByUsername(String username);

    T save(T t);

    List<T> saveAll(List<T> userList);
}
