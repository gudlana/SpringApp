package ua.gudlana.StadyGudLana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.service.CustomUserDetailsService;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    private String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String cresteNewUser(@Valid User user, BindingResult bindingResult, Model model){
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null){
            bindingResult
                    .rejectValue("email","error.user",
                            "There is already a user registered with the username provided");
        }
        if(bindingResult.hasErrors()){
            return "signup";
        }else{
            userService.saveUser(user);
            model.addAttribute("successMessage","User has been registered successfully");
            model.addAttribute("user", new User());
            return "";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("currentUser", user);
        model.addAttribute("username", "Welcome " + user.getUsername());
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        return "dashboard";
    }

}
