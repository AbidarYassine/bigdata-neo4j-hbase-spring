package com.irisi.immo.model.service;

import com.irisi.immo.model.bean.AnnonceType;

import java.io.IOException;
import java.util.List;

public interface AnnonceTypeService {

    AnnonceType save(AnnonceType annonceType) throws IOException;

    AnnonceType findById(String id) throws IOException;

    List<AnnonceType> findAll() throws IOException;

    void delete(String id) throws IOException;
}
