package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List getAllUsers();

    public User getUserById(Long id);

    public void saveUser(User user);

    public void updateUser(User user);

    public User deleteUserById(Long id);
}
