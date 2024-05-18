package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Model.User;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDao;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
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
    public User show(long s) {
        return userDao.show(s);
    }

    @Transactional(readOnly = false)
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
