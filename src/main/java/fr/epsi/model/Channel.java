package fr.epsi.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Channel")
public class Channel implements Serializable {

    @Id
    @GeneratedValue
    private int id;


    @Transient
    //@ManyToMany(mappedBy = "channels")
    private List<User> users;

    //@ManyToOne()
    @OneToMany(mappedBy = "channel", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE}) //mettre à jour de la mémoire
    //@JoinColumn(name ="message")
    private List<Message> messages;

    private boolean estPublic;

    public List<Message> getMessages(){ return messages;}
    public void setMessages(List<Message> sMessagerie){this.messages = sMessagerie;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public List<User> getUsers() {return users;}
    public void setUsers(List<User> users) {this.users = users;}

    /*Méthode des messages publiques*/
    public boolean getEstPublic() {
        return estPublic;
    }

    public void setEstPublic(boolean estPublic) {
        this.estPublic = estPublic;
    }
}
