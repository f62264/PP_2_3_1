package web.dao;

import web.models.User;

import java.util.List;

public interface JpaUserDao {
    List<User> getAll();

    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User deleteUserById(Long id);
}
