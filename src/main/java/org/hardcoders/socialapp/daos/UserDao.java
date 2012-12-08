package org.hardcoders.socialapp.daos;

import org.hardcoders.socialapp.core.GenericDaoImpl;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AGutierrez6
 * Date: 12/7/12
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends GenericDaoImpl<User> {

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public User findByUserName(String username) {
        Query myQuery = em.createQuery("select a from User a where a.username = :username");
        myQuery.setParameter("username", username);
        final List<User> myList = myQuery.getResultList();
        if (myList.size() == 1) {
            return myList.get(0);
        }
        if (myList.size() > 0) {
            throw new RuntimeException("Duplicated_user");
        }
        return null;
    }
}
