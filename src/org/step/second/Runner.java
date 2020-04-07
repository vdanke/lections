package org.step.second;

import org.step.second.data.UserData;
import org.step.second.model.User;
import org.step.second.service.UserService;
import org.step.second.service.impl.UserServiceImpl;

public class Runner {

    public static void main(String[] args) {
        UserService<User> userService = new UserServiceImpl();

        User byId = userService.findById(4L);

        System.out.println(byId.getUsername());

//        User save = userService.save(new User("fourth", "fourth"));
//
//        System.out.println(save.getId());
    }
}
