package com.findme.controller;

import com.findme.models.Post;
import com.findme.models.User;
import com.findme.service.PostService;
import com.findme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "saveUser", produces = "application/json")
    public @ResponseBody
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser", produces = "application/json")
    public @ResponseBody
    User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser", produces = "application/json")
    public @ResponseBody
    User delete(Long id) {
        return userService.delete(id);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "findUser", produces = "application/json")
//    public @ResponseBody
//    User findById(Model model, @PathVariable Long id) {
//        User user = userService.findById(id);
//        return userService.findById(id);
//    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String profile(Model model, @PathVariable Long userId) throws Exception {
        User user = userService.findById(userId);
        if (user == null) {
            throw new Exception("Profile user with id = " + userId + "is not found");
        } else {
            model.addAttribute("user", user);
        }
        return "profile";
    }

    @RequestMapping(path = "/user-registration", method = RequestMethod.POST)
    public User registerUser(@ModelAttribute User user) {
        return userService.save(user);
    }
}
