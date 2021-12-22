package com.irisi.immo.model.repository;


import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.irisi.immo.model.bean.Annonceur;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class AnnonceurDao extends AbstractHBDAO<String, Annonceur> {

    public AnnonceurDao(Connection connection) {
        super(connection);
    }
}
