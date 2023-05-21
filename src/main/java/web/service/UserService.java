package web.service;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

public interface UserService {
    public List getAllUsers();
    public User getUserById(Long id);
//    public void saveOrUpdate(User user);
    public void saveUser(User user);
    public void deleteUserById(Long id);
}
