package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;
import java.util.List;

@HBTable(name = "AnnonceType", families = {
        @Family(name = "main")
})
public class AnnonceType implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "type")
    private String type;
    @HBColumn(family = "main", column = "annonces")
    private List<Annonce> annonces;

    public AnnonceType() {
    }

    public AnnonceType(String id, String type, List<Annonce> annonces) {
        this.id = id;
        this.type = type;
        this.annonces = annonces;
    }

    @Override
    public String composeRowKey() {
        return type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
