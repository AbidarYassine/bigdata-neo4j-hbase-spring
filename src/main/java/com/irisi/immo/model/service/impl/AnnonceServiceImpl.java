package com.irisi.immo.model.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.*;
import com.irisi.immo.model.dao.AnnonceDao;
import com.irisi.immo.model.service.*;
import lombok.AllArgsConstructor;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService {

    private AnnonceDao annonceDao;
    private AnnonceTypeService annonceTypeService;
    private SecteurService secteurService;
    private AnnonceurService annonceurService;
    private CategoryService categoryService;

    @Override
    public Annonce save(Annonce annonce) throws IOException {

        AnnonceType annonceType = annonce.getAnnonceType();
        if (annonceType != null) {
            annonceType = annonceTypeService.findById(annonceType.getId());
            if (annonceType != null) {
                annonce.setAnnonceType(annonceType);
            } else {
                annonce.setAnnonceType(null);
            }
        }

        Secteur secteur = annonce.getSecteur();
        if (secteur != null) {
            secteur = secteurService.findById(secteur.getId());
            if (secteur != null) {
                annonce.setSecteur(secteur);
            } else {
                annonce.setSecteur(null);
            }
        }

        Annonceur annonceur = annonce.getAnnonceur();
        if (annonceur != null) {
            annonceur = annonceurService.findById(annonceur.getId());
            if (annonceur != null) {
                annonce.setAnnonceur(annonceur);
            } else {
                annonce.setAnnonceur(null);
            }
        }

        Category category = annonce.getCategory();
        if (category != null) {
            category = categoryService.findById(category.getId());
            if (category != null) {
                annonce.setCategory(category);
            } else {
                annonce.setCategory(null);
            }
        }

        String id = annonceDao.persist(annonce);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Annonce findById(String id) throws IOException {
        return annonceDao.get(id);
    }

    @Override
    public List<Annonce> findAll() throws IOException {
        List<Annonce> annonces = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Annonce> userRecords = annonceDao.records(scan)) {
            userRecords.forEach(annonces::add);
            return annonces;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        annonceDao.delete(id);
    }


}
