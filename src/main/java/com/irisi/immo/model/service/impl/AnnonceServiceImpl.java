package com.irisi.immo.model.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.Annonce;
import com.irisi.immo.model.repository.AnnonceDao;
import com.irisi.immo.model.service.AnnonceService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceDao annonceDao;

    @Override
    public Annonce save(Annonce annonce) throws IOException {
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
