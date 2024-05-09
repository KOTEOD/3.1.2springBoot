package web.Dao;

import org.springframework.stereotype.Service;
import Hiber.Model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> getUsers() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "1", 1));

        return listUser;
    }

    @Override
    public List<User> getUserById() {
        return getUsers();
    }
}
