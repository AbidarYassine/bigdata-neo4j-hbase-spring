package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;

@HBTable(name = "cities", families = {
        @Family(name = "main")
})
public class City implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "name")
    private String name;
    @HBColumn(family = "main", column = "codePostal")
    private String codePostal;

    @Override
    public String composeRowKey() {
        return name;
    }

    @Override
    public void parseRowKey(String s) {
        id = s;
    }
}
