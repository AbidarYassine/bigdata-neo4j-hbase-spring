package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;

@HBTable(name = "City", families = {
        @Family(name = "main")
})
public class City implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "name")
    private String name;
    @HBColumn(family = "main", column = "codePostal")
    private String codePostal;

    public City() {
    }

    public City(String id, String name, String codePostal) {
        this.id = id;
        this.name = name;
        this.codePostal = codePostal;
    }

    @Override
    public String composeRowKey() {
        return name;
    }

    @Override
    public void parseRowKey(String s) {
        id = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
