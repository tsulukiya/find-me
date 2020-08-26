package com.findme.controller;

import com.findme.exception.InternalServerError;
import com.findme.models.Post;
import com.findme.models.User;
import com.findme.service.PostService;
import com.findme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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
    public ResponseEntity<String> registerUser(@ModelAttribute User user) {
        return new ResponseEntity<>("Account is created", HttpStatus.OK);
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> userLogin(HttpSession session, @RequestParam(value = "phone") String login,
                                            @RequestParam(value = "password") String password) {
        try {
            User user = userService.userLogin(login, password);
            if (user == null) {
                return new ResponseEntity<>("Login or password incorrect. Code - 401", HttpStatus.UNAUTHORIZED);
            }
            if (session.getAttribute("userLogged") != null) {
                session.invalidate();
                session.setAttribute("userLogged", user);
                return new ResponseEntity<>("User with this login is already logged", HttpStatus.BAD_REQUEST);
            } else {
                session.setAttribute("userLogged", user);
            }

        } catch (InternalServerError error) {
            System.err.println(error.getMessage());
        }
        return new ResponseEntity<>("Welcome to FindMe! Code - 200", HttpStatus.OK);
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> userLogin(HttpSession session, @RequestParam(value = "phone") String login) {
        if (session.getAttribute("userLogged")!=null) {
            session.removeAttribute("userLogged");
            return new ResponseEntity<String>("User is logout!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Page - 404", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
