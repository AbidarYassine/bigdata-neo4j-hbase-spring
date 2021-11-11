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
import java.util.Date;


/**
 * @author yassine
 */
//@Document(collection = "annonces")
@Node("annonce")
public class Annonce implements Serializable {
    private static final long serialVersionUID = 6659221496655031009L;
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String reference;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String description;
    private String address;
    private boolean piscine;
    private int pices;
    private boolean active;
    private boolean processed;
    private String area;
    private String areaUnits;
    private String currency;
    private double price;

    private double lastPrice;
    private double first_price;
    private String chamber;

    private Date lastCheckDdate;
    private boolean status;
    private String codeStatus;
    private String latitude;
    private String longitude;
    private int rankObtained;
    private int rankMax;
    private boolean updatePrice;
    private boolean updateArea;
    private boolean urlExist;

    private Date newPriceDate;
    private String department;
    private String bathroom;
    private String surfaceLand;


    @Relationship(type = "HAS", direction = Relationship.Direction.INCOMING)
    private User annonceur;

    private Category category;

    private AnnonceType annonceTypeEntity;

    private City city;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public int getPices() {
        return pices;
    }

    public void setPices(int pices) {
        this.pices = pices;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaUnits() {
        return areaUnits;
    }

    public void setAreaUnits(String areaUnits) {
        this.areaUnits = areaUnits;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public Date getLastCheckDdate() {
        return lastCheckDdate;
    }

    public void setLastCheckDdate(Date lastCheckDdate) {
        this.lastCheckDdate = lastCheckDdate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getFirst_price() {
        return first_price;
    }

    public void setFirst_price(double first_price) {
        this.first_price = first_price;
    }

    public int getRankObtained() {
        return rankObtained;
    }

    public void setRankObtained(int rankObtained) {
        this.rankObtained = rankObtained;
    }

    public int getRankMax() {
        return rankMax;
    }

    public void setRankMax(int rankMax) {
        this.rankMax = rankMax;
    }

    public boolean isUpdatePrice() {
        return updatePrice;
    }

    public void setUpdatePrice(boolean updatePrice) {
        this.updatePrice = updatePrice;
    }

    public boolean isUpdateArea() {
        return updateArea;
    }

    public void setUpdateArea(boolean updateArea) {
        this.updateArea = updateArea;
    }

    public boolean isUrlExist() {
        return urlExist;
    }

    public void setUrlExist(boolean urlExist) {
        this.urlExist = urlExist;
    }

    public Date getNewPriceDate() {
        return newPriceDate;
    }

    public void setNewPriceDate(Date newPriceDate) {
        this.newPriceDate = newPriceDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getSurfaceLand() {
        return surfaceLand;
    }

    public void setSurfaceLand(String surfaceLand) {
        this.surfaceLand = surfaceLand;
    }

    public User getAnnonceur() {
        return annonceur;
    }

    public void setAnnonceur(User annonceur) {
        this.annonceur = annonceur;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AnnonceType getAnnonceTypeEntity() {
        return annonceTypeEntity;
    }

    public void setAnnonceTypeEntity(AnnonceType annonceTypeEntity) {
        this.annonceTypeEntity = annonceTypeEntity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + '}';
    }


}
