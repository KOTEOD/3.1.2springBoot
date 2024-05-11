package web.controller;

import Hiber.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Dao.UserService;

import java.util.List;


@Controller
//@RequestMapping()//анатация которая создаёт прификс /My
public class UserController {

    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/")
    public String showUser(Model model) {
        List<User> listUser = UserService.showUser();
        model.addAttribute("listUser", listUser);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@RequestParam(name = "id",required = false) int id, Model model) {
        model.addAttribute("User", UserService.getUser(id));
        return "user";
    }
}