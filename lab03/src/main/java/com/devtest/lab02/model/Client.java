package com.devtest.lab02.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private String code_client;
    private String nom;
    private String adresse;
    private String mail;
    private String tel;

    public Client() {
  
    }
 
    public Client(String code_client, String nom, String adresse, String mail, String tel) {
         this.code_client = code_client;
         this.nom = nom;
         this.adresse = adresse;
         this.mail = mail;
         this.tel = tel;
    }
 
    @Column(name = "code_client")
    public String getcode_client() {
        return code_client;
    }
    public void setcode_client(String code_client) {
        this.code_client = code_client;
    }
 
    @Column(name = "nom", nullable = false)
    public String getnom() {
        return nom;
    }
    public void setnom(String nom) {
        this.nom = nom;
    }
 
    @Column(name = "adresse", nullable = false)
    public String getadresse() {
        return adresse;
    }
    public void setadresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name = "mail", nullable = false)
    public String getmail() {
        return mail;
    }
    public void setmail(String mail) {
        this.mail = mail;
    }
    
    @Column(name = "tel", nullable = false)
    public String gettel() {
        return tel;
    }
    public void settel(String tel) {
        this.tel = tel;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(code_client, client.code_client) &&
                Objects.equals(nom, client.nom) &&  Objects.equals(adresse, client.adresse) && Objects.equals(adresse, client.adresse) && Objects.equals(mail, client.mail) && Objects.equals(tel, client.tel);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code_client, nom, adresse, mail, tel);
    }
    
    
    @Override
    public String toString() {
        return "Client [code_client=" + code_client + ", nom=" + nom + ", adresse=" + adresse+ ", mail=" + mail+ ", tel=" + tel
       + "]";
    }
 
}