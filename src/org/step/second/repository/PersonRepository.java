package org.step.second.repository;

import org.step.second.exceptions.WrongDataCheckedException;
import org.step.second.model.Person;

import java.util.List;

public interface PersonRepository<T extends Person> {

    T findById(Long id);

    T findByUsername(String username);

    T save(T t);

    List<T> saveAll(List<T> userList);
}
