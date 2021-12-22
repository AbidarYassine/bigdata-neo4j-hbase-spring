package com.irisi.immo.model.service;

import com.irisi.immo.model.bean.Secteur;

import java.io.IOException;
import java.util.List;

public interface SecteurService {

    Secteur save(Secteur secteur) throws IOException;

    Secteur findById(String id) throws IOException;

    List<Secteur> findAll() throws IOException;

    void delete(String id) throws IOException;
}
