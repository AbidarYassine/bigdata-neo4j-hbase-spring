package com.irisi.immo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.irisi.immo.model.bean.Annonce;
import com.irisi.immo.model.bean.User;
import com.irisi.immo.model.service.AnnonceService;
import com.irisi.immo.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService annonceService;
    private final Cloudinary cloudinary;
    private final UserService userService;
    int i = 0;

    String[] urls = {
            "https://static.pap.fr/photos/E00/E00A0216.jpg",
            "https://static.pap.fr/photos/D91/D91A0051.jpg",
            "https://static.pap.fr/photos/D95/D95A1273.jpg",
            "https://www.immoneuf.com/visuels/9/900284.jpg",
            "https://static.pap.fr/photos/D73/D73A0531.jpg"
    };


    public AnnonceController(AnnonceService annonceService, Cloudinary cloudinary, UserService userService) {
        this.annonceService = annonceService;
        this.cloudinary = cloudinary;
        this.userService = userService;
    }

    @PostMapping("/")
    public String insert(Annonce annonce, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {
        try {
            User user = userService.findByEmail(session.getAttribute("email").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        annonce.setAnnonceur(user);
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String url = uploadResult.get("url").toString();
            annonce.setUrl(url);
            annonceService.save(annonce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/id/{id}")
    public Annonce findByRef(@PathVariable String id) {
        try {
            return annonceService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        try {
            model.addAttribute("annonces", annonceService.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable String id) {
        try {
            annonceService.delete(id);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @GetMapping("/create")
    public String createAnnonce(Model model) {
        model.addAttribute("annonce", new Annonce());
        return "create";
    }
}
