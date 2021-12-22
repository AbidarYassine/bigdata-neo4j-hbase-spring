package com.irisi.immo.model.service.impl;


import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.Secteur;
import com.irisi.immo.model.repository.SecteurDao;
import com.irisi.immo.model.service.SecteurService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecteurServiceImpl implements SecteurService {

    @Autowired
    private SecteurDao secteurDao;


    @Override
    public Secteur save(Secteur secteur) throws IOException {
        String id = secteurDao.persist(secteur);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Secteur findById(String id) throws IOException {
        return secteurDao.get(id);
    }

    @Override
    public List<Secteur> findAll() throws IOException {
        List<Secteur> secteurs = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Secteur> userRecords = secteurDao.records(scan)) {
            userRecords.forEach(secteurs::add);
            return secteurs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        secteurDao.delete(id);
    }
}
