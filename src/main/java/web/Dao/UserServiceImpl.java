package web.Dao;

import org.springframework.stereotype.Service;
import Hiber.Model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static int i;
    private List<User> listUser;

    {
        listUser = new ArrayList<>();
        listUser.add(new User(i++, "Ivan", 25));
        listUser.add(new User(i++, "Andry", 21));
    }


    @Override
    public List<User> showUser() {
        return listUser;
    }

    @Override
    public User getUser(int s) {
        return listUser.get(s);
    }

    public void save(User user) {
        user.setId(i++);
        listUser.add(user);
    }
}
