package org.hardcoders.socialapp.services;

import org.hardcoders.socialapp.daos.UserDao;
import org.hardcoders.socialapp.daos.UserrouteDao;
import org.hardcoders.socialapp.model.User;
import org.hardcoders.socialapp.model.Userroute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import java.util.List;

/**
 * User: mmilton.loayza@gmail.com
 * Date: 12/7/12 9:11 PM
 */
public class UserrouteService {

    LocalEntityManagerFactoryBean entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(LocalEntityManagerFactoryBean entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Userroute> listAll()  {
        UserrouteDao dao = new UserrouteDao(entityManagerFactory.nativeEntityManagerFactory.createEntityManager());
        return dao.listAll(null );
    }



}
