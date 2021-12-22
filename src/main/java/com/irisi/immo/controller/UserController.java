package com.irisi.immo.controller;

import com.irisi.immo.controller.dto.LoginDto;
import com.irisi.immo.model.bean.Annonceur;
import com.irisi.immo.model.service.AnnonceurService;
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
    private final AnnonceurService annonceurService;


    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("annonceur", new Annonceur());
        return "register";
    }

    @GetMapping("/login")
    public String signInForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @SneakyThrows
    @PostMapping("/register")
    public String signUpForm(Annonceur annonceur, Model model, HttpSession session) {
        Annonceur savedAnnonceur = annonceurService.save(annonceur);
        session.setAttribute("login", true);
        session.setAttribute("email", savedAnnonceur.getEmail());
        return "redirect:/";
    }

    @SneakyThrows
    @PostMapping("/login")
    public String login(LoginDto login, Model model, HttpSession session) {
        log.info("test " + login);
        Annonceur annonceur = annonceurService.findByEmail(login.getEmail());
        if (annonceur.getPassword().equals(login.getPassword())) {
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
//    public String showAnnonceurList(Model model) {
//        model.addAttribute("annonceurs", annonceurService.findA());
//        return "index";
//    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        Annonceur annonceur = annonceurService.findByEmail(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid annonceur Id:" + id));
//
//        model.addAttribute("annonceur", annonceur);
//        return "update-annonceur";
//    }
}
