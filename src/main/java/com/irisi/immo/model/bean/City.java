/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irisi.immo.model.bean;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.util.List;

/**
 * @author yassine
 */
//@Document(collection = "cities")
@Node
public class City implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String codePostal;

    @Relationship(type = "INCLUDES")
    private List<Annonceur> annonces;


    private Secteur secteur;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Annonceur> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonceur> annonces) {
        this.annonces = annonces;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "City{" + "name=" + name + '}';
    }


}
