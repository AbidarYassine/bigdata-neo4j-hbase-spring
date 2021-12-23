package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;
import com.irisi.immo.model.util.AnnonceStatus;

import java.io.Serializable;
import java.math.BigDecimal;

@HBTable(name = "Annonce", families = {
        @Family(name = "main")
})
public class Annonce implements HBRecord<String>, Serializable {

    private String id;
    @HBColumn(family = "main", column = "title")
    private String title;
    @HBColumn(family = "main", column = "reference")
    private String reference;
    @HBColumn(family = "main", column = "description")
    private String description;
    @HBColumn(family = "main", column = "address")
    private String address;
    @HBColumn(family = "main", column = "piscine")
    private Boolean piscine;
    @HBColumn(family = "main", column = "pieces")
    private Integer pieces;
    @HBColumn(family = "main", column = "active")
    private Boolean active;
    @HBColumn(family = "main", column = "surface")
    private Double surface;
    @HBColumn(family = "main", column = "devise")
    private String devise;
    @HBColumn(family = "main", column = "prix")
    private BigDecimal prix;
    @HBColumn(family = "main", column = "chamber")
    private Integer chamber;
    @HBColumn(family = "main", column = "latitude")
    private String latitude;
    @HBColumn(family = "main", column = "longitude")
    private String longitude;
    @HBColumn(family = "main", column = "department")
    private String department;
    @HBColumn(family = "main", column = "toilet")
    private Integer toilet;
    @HBColumn(family = "main", column = "status")
    private AnnonceStatus status;
    @HBColumn(family = "main", column = "annonceur")
    private Annonceur annonceur;
    @HBColumn(family = "main", column = "category")
    private Category category;
    @HBColumn(family = "main", column = "annonceType")
    private AnnonceType annonceType;
    @HBColumn(family = "main", column = "secteur")
    private Secteur secteur;
    @HBColumn(family = "main", column = "url")
    private String url;

    public Annonce() {
    }

    public Annonce(String id, String title, String reference, String description, String address, Boolean piscine, Integer pieces, Boolean active, Double surface, String devise, BigDecimal prix, Integer chamber, String latitude, String longitude, String department, Integer toilet, AnnonceStatus status, Annonceur annonceur, Category category, AnnonceType annonceType, Secteur secteur) {
        this.id = id;
        this.title = title;
        this.reference = reference;
        this.description = description;
        this.address = address;
        this.piscine = piscine;
        this.pieces = pieces;
        this.active = active;
        this.surface = surface;
        this.devise = devise;
        this.prix = prix;
        this.chamber = chamber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.department = department;
        this.toilet = toilet;
        this.status = status;
        this.annonceur = annonceur;
        this.category = category;
        this.annonceType = annonceType;
        this.secteur = secteur;
    }

    @Override
    public String composeRowKey() {
        return title;
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

    public Boolean getPiscine() {
        return piscine;
    }

    public void setPiscine(Boolean piscine) {
        this.piscine = piscine;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Integer getChamber() {
        return chamber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setChamber(Integer chamber) {
        this.chamber = chamber;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public AnnonceStatus getStatus() {
        return status;
    }

    public void setStatus(AnnonceStatus status) {
        this.status = status;
    }

    public Annonceur getAnnonceur() {
        return annonceur;
    }

    public void setAnnonceur(Annonceur annonceur) {
        this.annonceur = annonceur;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AnnonceType getAnnonceType() {
        return annonceType;
    }

    public void setAnnonceType(AnnonceType annonceType) {
        this.annonceType = annonceType;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
