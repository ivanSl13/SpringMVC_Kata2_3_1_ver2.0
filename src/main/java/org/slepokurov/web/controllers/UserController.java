package org.slepokurov.web.controllers;

import org.slepokurov.web.model.User;
import org.slepokurov.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
    return "users";
    }

    @GetMapping("users/{id}")
    public String getUserId (@PathVariable("id") int id, Model model) {
            userService.getOneUser(id);
            model.addAttribute("oneuser", userService.getOneUser(id));
        return "userpages";
    }

    @GetMapping("/users/add")
    public String newUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user",userService.getOneUser(id));
        return "edit";
    }
    @PatchMapping ("/users/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updatUser(id, user);
        return "redirect:/users";
    }
    @DeleteMapping ("/users/{id}")
    public String delete (@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/")
    public String hello() {
        return "hello";
    }
//
//    @GetMapping("/")
//    @ResponseBody
//    public String helloWorld() {
//        return "HelloWorld";
//    }
}
