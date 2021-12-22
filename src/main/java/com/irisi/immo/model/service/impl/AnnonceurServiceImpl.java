package com.irisi.immo.model.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.Annonceur;
import com.irisi.immo.model.repository.AnnonceurDao;
import com.irisi.immo.model.service.AnnonceurService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceurServiceImpl implements AnnonceurService {

    @Autowired
    private AnnonceurDao annonceurDao;


    @Override
    public Annonceur save(Annonceur annonceur) throws IOException {
        String id = annonceurDao.persist(annonceur);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Annonceur findById(String id) throws IOException {
        return annonceurDao.get(id);
    }

    @Override
    public List<Annonceur> findAll() throws IOException {
        List<Annonceur> annonceurs = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Annonceur> userRecords = annonceurDao.records(scan)) {
            userRecords.forEach(annonceurs::add);
            return annonceurs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        annonceurDao.delete(id);
    }
}
