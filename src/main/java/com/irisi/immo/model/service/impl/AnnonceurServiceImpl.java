package com.irisi.immo.model.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.Annonceur;
import com.irisi.immo.model.bean.City;
import com.irisi.immo.model.dao.AnnonceurDao;
import com.irisi.immo.model.service.AnnonceurService;
import com.irisi.immo.model.service.CityService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnnonceurServiceImpl implements AnnonceurService {

    private AnnonceurDao annonceurDao;
    private CityService cityService;


    @Override
    public Annonceur save(Annonceur annonceur) throws IOException {

        City city = annonceur.getCity();
        if (city != null) {
            city = cityService.findById(city.getId());
            if (city != null) {
                annonceur.setCity(city);
            } else {
                annonceur.setCity(null);
            }
        }
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

    @Override
    @SneakyThrows
    public Annonceur findByEmail(String email) {
        return findAll().stream().filter((ele) -> ele.getEmail().equals(email)).findFirst().get();
    }
}
