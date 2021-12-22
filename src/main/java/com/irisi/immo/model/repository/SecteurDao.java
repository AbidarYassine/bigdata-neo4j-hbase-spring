package com.irisi.immo.model.repository;


import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.irisi.immo.model.bean.Secteur;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class SecteurDao extends AbstractHBDAO<String, Secteur> {

    public SecteurDao(Connection connection) {
        super(connection);
    }
}
