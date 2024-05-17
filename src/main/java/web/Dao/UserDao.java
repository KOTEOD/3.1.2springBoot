package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User show(long id);
    void save(User user);
    void update(long id,User user);
    void delete(long id);
}
