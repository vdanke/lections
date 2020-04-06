package org.step.second.model;

import org.step.second.IdStringViewer;

public class User implements IdStringViewer<String> {

    private Long id;
    private String username;
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getIdAsString() {
        return this.id.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + id.intValue();
        result = prime * result + username.hashCode();
        result = prime * result + password.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;

        if (!id.equals(other.id)) {
            return false;
        }
        if (!username.equals(other.username)) {
            return false;
        }
        if (!password.equals(other.password)) {
            return false;
        }
        return true;
    }
}
