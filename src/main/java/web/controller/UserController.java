package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.Dao.UserService;
import Hiber.Model.User;

import java.util.List;

@Controller
public class UserController {

    private final UserService UserService;
    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/")
    public String users(Model model) {
        List<User> result = UserService.getUserById();
        model.addAttribute("listUser",result);
        return "users";
    }
}
