package org.step.second.data;

import org.step.second.annot.MyAnnotation;
import org.step.second.model.User;

import java.util.*;

public class UserData {

    @MyAnnotation(value = "This is empty user")
    public static final User EMPTY_USER = new User(100L, "empty", "empty");

    private static Map<Long, User> findById = new HashMap<>();
    private static Map<String, User> findByUsername = new HashMap<>();
    private static List<User> userList = new ArrayList<>();

    static {
        userList.addAll(Arrays.asList(
                new User((long) 1, "first", "firstpassword"),
                new User((long) 2, "second", "secondpassword"),
                new User((long) 3, "third", "thirdpassword")
        ));
        userList.forEach(user -> {
            findById.put(user.getId(), user);
            findByUsername.put(user.getUsername(), user);
        });
    }

    public User findById(Long id) {
        return findById.get(id);
    }

    public User findByUsername(String username) {
        return findByUsername.get(username);
    }

    public User save(User user) {
        OptionalLong max = userList.stream()
                .mapToLong(User::getId)
                .max();

        if (max.isPresent()) {
            long asLong = max.getAsLong();
            long newId = ++asLong;

            user.setId(newId);

            userList.add(user);

            return user;
        }
        return EMPTY_USER;
    }

    @MyAnnotation(value = "This is user")
    public List<? extends User> saveAll(List<? extends User> users) {
        userList.addAll(users);
        return users;
    }

    public static Map<Long, User> getUserMapById() {
        return findById;
    }

    public static Map<String, User> getUserMapByUsername() {
        return findByUsername;
    }

    public static List<User> getUserList() {
        return userList;
    }
}
