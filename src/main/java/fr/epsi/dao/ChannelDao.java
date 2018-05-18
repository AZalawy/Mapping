package fr.epsi.dao;

import fr.epsi.model.Channel;
import fr.epsi.model.Message;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.IntStream;

public class ChannelDao extends AbstractDao<Channel> {

    /*Filtrer les messages,soit public ou privé*/
    public List<Message> lesMessageries(String msg, boolean reponse){
        return this.execute((session )-> {
            int size = Integer.parseInt(msg);
            //int size = msg.size();
            StringBuilder builder = new StringBuilder("From Tweet Where message like:msg");
            IntStream.range(1, size).forEach(i-> builder.append(" and messages like :msp" +i));

            Query query = session.createQuery(builder.toString());
            IntStream.range(0, size).forEach(i-> query.setParameter("msg" + i, "@" + msg +"%"));
            return query.list();
        });
    }

    public List<Message> chercherConservations(String unMsg) {
        return this.lesMessageries(unMsg, true);
    }

    public List<Message> getMieuxNote(Channel channel) {
        return this.execute(session -> { return session.createQuery("from Message order by note").list();});
    }
}
