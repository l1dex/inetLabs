package db.DAO;

import db.HibernateUtil;
import db.model.Users;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UsersDAO {
    private SessionFactory sessionFactory;
    public UsersDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean create(Users user){
        if(getUserByLogin(user.getLogin()) == null){
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }
            return true;
        }
        return false;
    }

    public Users getUserByLogin(String login){
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("from Users where login = :paramName");
            query.setParameter("paramName", login);
            List<Users> results = query.list();
            System.out.println(results.size());
            if(results.size() > 0){
                return results.get(0);
            }
        }
        return null;
    }

}
