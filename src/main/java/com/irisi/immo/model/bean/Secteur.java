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

@HBTable(name = "secteurs", families = {
        @Family(name = "Info")
})
public class Secteur implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "Info", column = "libelle")
    private String libelle;
    @HBColumn(family = "Info", column = "code")
    private String code;
    @HBColumn(family = "Info", column = "city")
    private City city;

    @Override
    public String composeRowKey() {
        return libelle;
    }

    @Override
    public void parseRowKey(String s) {
        id = s;
    }
}
