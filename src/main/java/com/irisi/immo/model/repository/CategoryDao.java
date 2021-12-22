package com.irisi.immo.model.repository;


import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.irisi.immo.model.bean.Category;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class CategoryDao extends AbstractHBDAO<String, Category> {

    public CategoryDao(Connection connection) {
        super(connection);
    }
}
