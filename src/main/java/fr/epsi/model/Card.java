package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="card")
public class Card implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String code;

    /*Aministrateur possède plusieurs cartes bancaires*/
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    /*Code de la carte bancaire?*/
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public Admin getAdmin() {return admin;}
    public void setAdmin(Admin admin) {this.admin = admin;}
}
