package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;
import java.util.List;

@HBTable(name = "Annonceur", families = {
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

    public Annonceur() {
    }

    public Annonceur(String id, String firstname, String lastname, String telephone, String email, String password, String address, City city, List<Annonce> annonces) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.annonces = annonces;
    }

    @Override
    public String composeRowKey() {
        return email.split("@")[0];
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
