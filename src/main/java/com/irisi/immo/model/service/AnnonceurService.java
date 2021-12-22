package com.irisi.immo.model.service;

import com.irisi.immo.model.bean.Annonceur;

import java.io.IOException;
import java.util.List;

public interface AnnonceurService {

    Annonceur save(Annonceur annonceur) throws IOException;

    Annonceur findById(String id) throws IOException;

    List<Annonceur> findAll() throws IOException;

    void delete(String id) throws IOException;
}
