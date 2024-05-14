package web.Dao;

import org.springframework.stereotype.Service;
import Hiber.Model.User;
import web.servisr.UserDao;
import web.servisr.UserDaoImpl;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User show(int s) {
        return userDao.show(s);
    }

    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
