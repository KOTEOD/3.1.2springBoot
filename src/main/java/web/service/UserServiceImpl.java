package web.service;

import org.springframework.stereotype.Service;
import web.Model.User;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDao;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int s) {
        return userDao.show(s);
    }

    @Transactional(readOnly = false)
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Transactional(readOnly = false)
    @Override
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }
    @Transactional(readOnly = false)
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
