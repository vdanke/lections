package org.step.second;

import org.step.second.model.User;
import org.step.second.service.UserCounter;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        UserCounter userCounter = new UserCounter(Arrays.asList(
                new User((long) 1, "first", "firstpassword"),
                new User((long) 2, "second", "secondpassword"),
                new User((long) 3, "third", "thirdpassword")
        ));

        User user = new User((long) 1, "first", "firstpassword");
        int userCount = userCounter.getUserCount();

        System.out.println(userCount);
        System.out.println(user.equals(userCounter.getUserList().get(0)));
    }
}
