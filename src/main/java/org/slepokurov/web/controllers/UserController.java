package org.slepokurov.web.controllers;

import org.slepokurov.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/use")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
    return "users";
    }

//    @GetMapping("/{id}")
//    public String getUserId (@PathVariable("id") int id, Model model) {
//
//        return null;
//    }

//    @GetMapping(value = "/g")
//    public String hello() {
//        return "hello";
//    }
//
    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "HelloWorld";
    }
}
