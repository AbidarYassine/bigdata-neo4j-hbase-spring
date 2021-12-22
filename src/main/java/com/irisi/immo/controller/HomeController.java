package com.irisi.immo.controller;

import com.irisi.immo.model.service.AnnonceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final AnnonceService annonceService;

    public HomeController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @SneakyThrows
    @GetMapping()
    public String getHome(Model model) {
        model.addAttribute("annonces", annonceService.findAll());
        return "index";
    }
}
