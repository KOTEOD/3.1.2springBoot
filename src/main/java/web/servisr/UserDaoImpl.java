package web.servisr;

import Hiber.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static int i = 0;
    private final List<User> listUser;

    {
        listUser = new ArrayList<>();
        listUser.add(new User(i++, "Ivan", 25));
        listUser.add(new User(i++, "Andry", 21));
    }

    @Override
    public List<User> getAllUser() {
        return listUser;
    }

    @Override
    public User show(int id) {
        return getAllUser().get(id);
    }

    @Override
    public void save(User user) {
        user.setId(i++);
        getAllUser().add(user);
    }

    @Override
    public void update(int id, User user) {
        User user1 = show(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        User user = show(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        } else {
            getAllUser().remove(id);
        }
    }

//    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.getAllUser());
//        userDao.getAllUser().remove(1);
//        System.out.println(userDao.getAllUser());
//    }
}
