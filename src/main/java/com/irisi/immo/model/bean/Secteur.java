/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

import java.io.Serializable;

@HBTable(name = "Secteur", families = {
        @Family(name = "main")
})
public class Secteur implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "libelle")
    private String libelle;
    @HBColumn(family = "main", column = "code")
    private String code;
    @HBColumn(family = "main", column = "city")
    private City city;

    public Secteur() {
    }

    public Secteur(String id, String libelle, String code, City city) {
        this.id = id;
        this.libelle = libelle;
        this.code = code;
        this.city = city;
    }

    @Override
    public String composeRowKey() {
        return libelle;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
