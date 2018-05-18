package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Tweet")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@ManyToOne
    //@ManyToOne
    //@JoinColumn(name="tweet_id");
    private long idTweet;
    private String message;
    //private User idUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "channel_id") /*jointure la chaine pour les conservations*/
    private Channel channel;

    public long getIdTweet() {return idTweet;}

    public void setIdTweet(long id){ this.idTweet = id;}

    public String getMessage() {return message;}

    public void setMessage(String sMessage){this.message = sMessage;}

    public User getIdUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
