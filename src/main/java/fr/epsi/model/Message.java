package fr.epsi.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "idChannel")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "idCUser")
    private User user;

    private String message;
    private int note;

    public Channel getChannel() {return channel;}

    public void setChannel(Channel channel) {this.channel = channel;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getNote() {return note;}

    public void setNote(int note) {this.note = note;}
}
