package com.irisi.immo.model.service.impl;


import com.flipkart.hbaseobjectmapper.Records;
import com.irisi.immo.model.bean.Category;
import com.irisi.immo.model.repository.CategoryDao;
import com.irisi.immo.model.service.CategoryService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public Category save(Category category) throws IOException {
        String id = categoryDao.persist(category);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Category findById(String id) throws IOException {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> findAll() throws IOException {
        List<Category> categorys = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Category> userRecords = categoryDao.records(scan)) {
            userRecords.forEach(categorys::add);
            return categorys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        categoryDao.delete(id);
    }
}
