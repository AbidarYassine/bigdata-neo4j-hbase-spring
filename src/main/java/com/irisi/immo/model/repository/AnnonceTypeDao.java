package com.irisi.immo.model.repository;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.irisi.immo.model.bean.AnnonceType;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class AnnonceTypeDao extends AbstractHBDAO<String, AnnonceType> {

    public AnnonceTypeDao(Connection connection) {
        super(connection);
    }
}
