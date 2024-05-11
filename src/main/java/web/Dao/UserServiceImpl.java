package web.Dao;

import org.springframework.stereotype.Service;
import Hiber.Model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public List<User> User() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "Ivan", 25));
        listUser.add(new User(2, "Andry", 21));
        return listUser;
    }
    @Override
    public List<User> showUser() {
        return User();
    }

    @Override
    public User getUser(int s) {
        List<User> listUser = User();
        return listUser.get(s);
    }
}
