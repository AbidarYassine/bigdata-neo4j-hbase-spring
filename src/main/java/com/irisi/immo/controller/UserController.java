package com.irisi.immo.controller;

import com.irisi.immo.controller.dto.LoginDto;
import com.irisi.immo.model.bean.User;
import com.irisi.immo.model.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {
    private final UserDao userDao;

    @Autowired


    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String signInForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/register")
    public String signUpForm(User user, Model model, HttpSession session) {
        User result = userDao.save(user);
        session.setAttribute("login", true);
        session.setAttribute("email", user.getEmail());
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(LoginDto login, Model model, HttpSession session) {
        log.info("test " + login);
        User user = userDao.findByEmail(login.getEmail());
        if (user.getPassword().equals(login.getPassword())) {
            session.setAttribute("login", true);
            session.setAttribute("email", login.getEmail());
            return "redirect:/";
        } else {
            return "login";
        }

    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("login");
        session.removeAttribute("email");
        return "redirect:/";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }
}
