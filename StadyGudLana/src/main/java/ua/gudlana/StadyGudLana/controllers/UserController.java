package ua.gudlana.StadyGudLana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.gudlana.StadyGudLana.data.domain.Post;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private List<User> userList;

//    @GetMapping("/users")
//    public String listUsers(Model model){
//        model.addAttribute("users", userService.findAll());
//        return "users_list";
//    }

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(required = false,defaultValue = "") String searchUser){

        if(searchUser != null && !searchUser.isEmpty()){
            userList = userService.findByUsername(searchUser);
        }else{
            userList = userService.findAll();
        }
        model.addAttribute("users",userList);
        return "users_list";
    }
}
