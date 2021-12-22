package com.irisi.immo.model.service;


import com.irisi.immo.model.bean.Annonce;

import java.io.IOException;
import java.util.List;

public interface AnnonceService {

    Annonce save(Annonce annonce) throws IOException;

    Annonce findById(String id) throws IOException;

    List<Annonce> findAll() throws IOException;

    void delete(String id) throws IOException;
}
