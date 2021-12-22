package com.irisi.immo.model.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.irisi.immo.model.bean.Annonce;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class AnnonceDao extends AbstractHBDAO<String, Annonce> {

    public AnnonceDao(Connection connection) {
        super(connection);
    }
}
