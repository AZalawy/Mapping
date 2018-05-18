package fr.epsi.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
/*@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})*/
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthday;
    @Formula("(TIMESTAMPDIFF('YEAR', birthday, CURDATE()))")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "User_Channel",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "channel_id") }
    )
    private List<Channel> channels;

    @Transient
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> followers;


    private String password; //attribut de mdp
    private String pseudo; //attribut de pseudonyme ou login

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="idMessage")
    private List<Message> messages;


    @Formula("YEAR(GETDATE()) - YEAR(birthday)")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {return email;}

    public void setEmail(String email){this.email = email;}

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge(){return age;}


    public String getPassword(){return password;} //lire le mdp

    public void setPassword(String sPassword){ this.password = sPassword;} //saisir le mdp

    public String getPseudo(){return pseudo;} //lecture le pseudo

    public void setPseudo(String sPseudo){ this.pseudo = sPseudo;} //saisir le pseudo

    public List<Channel> getChannels() {return channels;}

    public void setChannels(List<Channel> channels) {this.channels = channels;}

    public List<Message> getMessages() {return messages;}

    public void setMessages(List<Message> lesMessages){this.messages= lesMessages;}

}
