package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "' ").uniqueResult();
    }

    @Override
    public User findUserById(Long id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = '" + id + "' ").uniqueResult();
    }
}
