package fr.epsi.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "admin")
public class Admin extends User{

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*Un administrateur possède un ou plusieurs cartes bancaires*/
    @Transient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cards")
    @Fetch(value = FetchMode.SUBSELECT)

    @Cascade(CascadeType.SAVE_UPDATE)
    //@OneToMany(mappedBy = "cards", Fe)
   // @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Card> carteBancaire;

    public List<Card> getCards(){return carteBancaire;}
    public void setCards(List<Card> lesCartes){this.carteBancaire = lesCartes;}


    /*@Column(name="alias")
    public String toString(){
        return " @ " + getNickname()  ; //ou utiliser l'attribut de pseudo
    }*/
}
