package com.swastik.user;

import java.util.List;

public interface IUserService {

    public User createUser(User user);

    public User retrieveUser(Integer id);

    public List<User> retrieveUsers();

    public User updateUser(User user);

}