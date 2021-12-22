package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;
import java.util.List;

@HBTable(name = "annonceurs", families = {
        @Family(name = "main")
})
public class Annonceur implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "firstname")
    private String firstname;
    @HBColumn(family = "main", column = "lastname")
    private String lastname;
    @HBColumn(family = "main", column = "telephone")
    private String telephone;
    @HBColumn(family = "main", column = "email")
    private String email;
    @HBColumn(family = "main", column = "password")
    private String password;
    @HBColumn(family = "main", column = "address")
    private String address;
    @HBColumn(family = "main", column = "city")
    private City city;
    @HBColumn(family = "main", column = "annonces")
    private List<Annonce> annonces;


    @Override
    public String composeRowKey() {
        return email.split("@")[0];
    }

    @Override
    public void parseRowKey(String s) {
        id = s;
    }
}
