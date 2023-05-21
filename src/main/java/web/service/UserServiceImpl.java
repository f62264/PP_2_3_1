package web.service;

import org.springframework.stereotype.Service;
import web.dao.JpaUserDao;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final JpaUserDao userDao;

    public UserServiceImpl(JpaUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User deleteUserById(Long id) {
        User user = null;
        try {
            user = userDao.deleteUserById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}
