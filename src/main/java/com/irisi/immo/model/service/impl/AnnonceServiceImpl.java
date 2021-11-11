package com.irisi.immo.model.service.impl;

import com.irisi.immo.model.bean.Annonce;
import com.irisi.immo.model.repository.AnnonceDao;
import com.irisi.immo.model.service.facade.AnnonceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private final AnnonceDao annonceDao;

    public AnnonceServiceImpl(AnnonceDao annonceDao) {
        this.annonceDao = annonceDao;
    }

    @Override
    public Annonce insert(Annonce annonce) {
        return annonceDao.save(annonce);
    }

    @Override
    public Annonce findByRef(Long id) {
        return annonceDao.findById(id).get();
    }

    @Override
    public List<Annonce> findAll() {
        return annonceDao.findAll();
    }

    @Override
    public int delete(Long id) {
        annonceDao.deleteById(id);
        return 1;
    }
}
