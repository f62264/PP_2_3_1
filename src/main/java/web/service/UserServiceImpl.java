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
    public void deleteUserById(Long id) {

    }

    //    @Transactional
//    @Override
//    public void saveOrUpdate(User user) {
//       if (0 == user.getId()) {
//          userDao.addUser(user);
//       } else {
//           userDao.updateUser(user);
//       }
//    }

}
