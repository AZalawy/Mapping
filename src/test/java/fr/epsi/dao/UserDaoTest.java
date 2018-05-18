package fr.epsi.dao;

import fr.epsi.model.*;
import fr.epsi.model.Channel;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setEmail("test@mail.com");
        user.setPassword("Mdp");
        user.setPseudo("Test");
        user.setFirstname("Aurélie");
        user.setLastname("Tetrel");

        long id = new UserDao().save(user);

        //User u = new UserDao().get(id).getPseudo();
        Assert.assertEquals("Aurélie", new UserDao().get(id).getPseudo());
    }

       @Test
       public void lesMessages(){
           User user = new User();
           user.setEmail("test@gmail.com");
           user.setPassword("Mdp");
           user.setPseudo("Test");

           Message message = new Message();
           message.setMessage("Hello");
           message.setUser(user);

           Long id = new UserDao().save(user);

           Assert.assertEquals(1, new UserDao().get(id).getMessages());
       }

    @Test /*Administrateur associé un ou plusieurs cartes bancaires*/
    public void carteBancaire(){
        Admin admin = new Admin();
        admin.setEmail("Test@gmail.com");
        admin.setPassword("toto");
        admin.setPseudo("Toto");

        //admin.getFirstname();
        //admin.getLastname();

        Card cb = new Card();
        cb.setCode("000000000");
        cb.setAdmin(admin);


        cb.setAdmin(admin);

        admin.setCards(Collections.singletonList(cb));

        Long id = new AdminDao().save(admin);

        Assert.assertEquals("Administrateur", admin.getNickname());
        Assert.assertEquals(1,new AdminDao().get(id).getCards().size());
    }

    @Test
    public void chercherMessages(){
        new ChannelDao().chercherConservations("Hello").forEach(message -> System.out.print(message));
    }

    //@Test /*Messages mieux notés*/
    /*public void plusMieuxNotes() {
        List<User> users;
        Channel channel = new Channel();
        channel.setEstPublic(true);
        channel.setName("Name");

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("Mdp");
        user.setPseudo("Test");

        channel.setUsers(user);

        Message message = new Message();
        message.setMessage("Bonjour tout monde");
        message.setUser(user);
        message.setNote(1);

        Message message2 = new Message();
        message2.setMessage("Plop");
        message2.setUser(user);
        message2.setNote(-1);

        user.setMessages(Arrays.asList(message, message2));
        new ChannelDao().save(channel);

        Assert.assertEquals(2, new ChannelDao().getMostLiked(channel).get(0).getNote());
    }*/
}
