package com.devtest.lab02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {
	
	private long id;
    private String nom;
    private String code_barre;
    private String description;
    private float qte;
    private String image;

    public Article() {
  
    }
 
    public Article(String nom, String code_barre, String description, float qte, String image) {
         this.nom = nom;
         this.code_barre = code_barre;
         this.description = description;
         this.qte = qte;
         this.image = image;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "nom")
    public String getnom() {
        return nom;
    }
    public void setnom(String nom) {
        this.nom = nom;
    }
 
    @Column(name = "code_barre", nullable = false)
    public String getcode_barre() {
        return code_barre;
    }
    public void setcode_barre(String code_barre) {
        this.code_barre = code_barre;
    }
 
    @Column(name = "description", nullable = false)
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }

    @Column(name = "qte", nullable = false)
    public float getqte() {
        return qte;
    }
    public void setqte(float qte) {
        this.qte = qte;
    }
    
    @Column(name = "image", nullable = false)
    public String getimage() {
        return image;
    }
    public void setimage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "Article [id=" + id +",nom=" + nom + ", code_barre=" + code_barre + ", description=" + description+ ", qte=" + qte+ ", image=" + image
       + "]";
    }
 
}