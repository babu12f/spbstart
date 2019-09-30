package com.example.demo;

import java.util.List;


public interface UserService {
    public void createUser(User user);
    public List<User> getUser();
    public User findById(long id);
    public User update(User user, long l);
    public void deleteUserById(long id);
    public User updatePartially(User user, long id);
}
