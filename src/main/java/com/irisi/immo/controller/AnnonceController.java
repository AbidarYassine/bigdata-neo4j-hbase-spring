package com.irisi.immo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.irisi.immo.model.bean.Annonce;
import com.irisi.immo.model.bean.User;
import com.irisi.immo.model.repository.UserDao;
import com.irisi.immo.model.service.facade.AnnonceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService annonceService;
    private final Cloudinary cloudinary;
    private final UserDao userDao;
    int i = 0;

    String[] urls = {
            "https://static.pap.fr/photos/E00/E00A0216.jpg",
            "https://static.pap.fr/photos/D91/D91A0051.jpg",
            "https://static.pap.fr/photos/D95/D95A1273.jpg",
            "https://www.immoneuf.com/visuels/9/900284.jpg",
            "https://static.pap.fr/photos/D73/D73A0531.jpg"
    };


    public AnnonceController(AnnonceService annonceService, Cloudinary cloudinary, UserDao userDao) {
        this.annonceService = annonceService;
        this.cloudinary = cloudinary;
        this.userDao = userDao;
    }

    @PostMapping("/")
    public String insert(Annonce annonce, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {
        User user = userDao.findByEmail(session.getAttribute("email").toString());
        annonce.setAnnonceur(user);
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String url = uploadResult.get("url").toString();
            annonce.setUrl(url);
            annonceService.insert(annonce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/id/{id}")
    public Annonce findByRef(@PathVariable Long id) {
        return annonceService.findByRef(id);
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("annonces", annonceService.findAll());
        return "index";
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return annonceService.delete(id);
    }

    @GetMapping("/create")
    public String createAnnonce(Model model) {
        model.addAttribute("annonce", new Annonce());
        return "create";
    }
}
