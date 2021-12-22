package com.irisi.immo.controller;

import com.irisi.immo.controller.dto.LoginDto;
import com.irisi.immo.model.bean.User;
import com.irisi.immo.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


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

    @SneakyThrows
    @PostMapping("/register")
    public String signUpForm(User user, Model model, HttpSession session) {
        userService.save(user);
        session.setAttribute("login", true);
        session.setAttribute("email", user.getEmail());
        return "redirect:/";
    }

    @SneakyThrows
    @PostMapping("/login")
    public String login(LoginDto login, Model model, HttpSession session) {
        log.info("test " + login);
        User user = userService.findByEmail(login.getEmail());
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

//    @GetMapping("/index")
//    public String showUserList(Model model) {
//        model.addAttribute("users", userService.findA());
//        return "index";
//    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userService.findByEmail(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("user", user);
//        return "update-user";
//    }
}
