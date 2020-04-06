package org.step.second.service;

import org.step.second.model.User;

import java.util.List;

public class UserCounter {

    private List<? extends User> userList;

    public UserCounter(List<? extends User> userList) {
        this.userList = userList;
    }

    public int getUserCount() {
        return userList.size();
    }

    public List<? extends User> getUserList() {
        return userList;
    }

    public void setUserList(List<? extends User> userList) {
        this.userList = userList;
    }
}
