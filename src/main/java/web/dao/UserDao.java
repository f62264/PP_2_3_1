package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User deleteUserById(Long id);
}
