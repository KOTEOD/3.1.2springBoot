package web.Dao;

import Hiber.Model.User;

import java.util.List;

public interface UserService {
    List<User> getUserById();
}
