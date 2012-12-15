package org.hardcoders.socialapp.services;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.hardcoders.socialapp.core.Point;
import org.hardcoders.socialapp.core.Route;
import org.hardcoders.socialapp.daos.ConflictoDao;
import org.hardcoders.socialapp.daos.UserDao;
import org.hardcoders.socialapp.daos.UserrouteDao;
import org.hardcoders.socialapp.model.Authentication;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.User;
import org.hardcoders.socialapp.model.Userroute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: AGutierrez6
 * Date: 12/7/12
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserService {

	EntityManager entityManager;
	
    @Autowired
    public void setEntityManagerFactory(LocalEntityManagerFactoryBean entityManagerFactory) {
		this.entityManager = entityManagerFactory.nativeEntityManagerFactory.createEntityManager();
    }

    public User findById(Long userId) {
        UserDao dao = new UserDao(entityManager);
        return dao.find(userId);
    }

    public User findByUserName(String username_email) {
        UserDao dao = new UserDao(entityManager);
        return dao.findByUserName(username_email);
    }

    public User createUser(String username_email, String password) {
        UserDao dao = new UserDao(entityManager);
        User oldUser = dao.findByUserName(username_email);
        if (oldUser != null) {
            throw new RuntimeException("User already registered");
        }
        User user = new User();
        user.setAuthentication(Authentication.USER_PASSWORD.toString());
        user.setUsername(username_email);
        user.setEmail(username_email);
        user.setPassword(hash(password));
        dao.create(user);
        return user;
    }

    public User updateUser(User user) {
        UserDao dao = new UserDao(entityManager);
        return dao.update(user);
    }

    public boolean loginUserWithPassword(String username, String password) {
        UserDao dao = new UserDao(entityManager);
        User user = dao.findByUserName(username);
        if (user == null) {
            return false;
        }
        if (StringUtils.equals(user.getPassword(), hash(password))) {
            return true;
        }
        return false;
    }

    public List<User> getUserByAffectedConflicto(long conflictoId) {
        List<User> result = new ArrayList<User>();

        // get all routes and points
        UserrouteDao dao = new UserrouteDao(entityManager);
        List<Userroute> userroutes = dao.listAll(null);

        ConflictoDao conflictoDao = new ConflictoDao(entityManager);
        Conflicto conflicto = conflictoDao.find(conflictoId);

        UserDao userDao = new UserDao(entityManager);

        for (Userroute userroute : userroutes) {
            if (routeMatchesConflict(conflicto, userroute)) {
                result.add(userDao.find(userroute.getUserId()));
            }
        }
        return result;
    }


    private boolean routeMatchesConflict(Conflicto conflicto, Userroute userroute) {
        Point point = getPoint(conflicto);
        Route route = getRoute(userroute);




        return true;


    }

    private Route getRoute(Userroute userroute) {
        Route route = new Route();
        String googleRoute = userroute.getGoogleRoute();
        Gson gson = new Gson();
        Map map = gson.fromJson(googleRoute, Map.class);
        Map start = (Map)map.get("start");
        route.getPoints().add(new Point((Double)start.get("lat"), (Double)start.get("lng")));

        List listPoints = (List)map.get("points");
        for (Object listPoint : listPoints) {
            List l = (List)listPoint;
            route.getPoints().add(new Point((Double)l.get(0), (Double)l.get(1)));
        }

        Map end = (Map)map.get("end");
        route.getPoints().add(new Point((Double)end.get("lat"), (Double)end.get("lng")));
        return route;
    }

    private Point getPoint(Conflicto conflicto) {
        Point point = new Point();
        point.setY(conflicto.getMapX());
        point.setX(conflicto.getMapY());
        point.setRatio(conflicto.getRatio());
        return point;
    }


    public String hash(String input) {
        MessageDigest cript;
        try {
            cript = MessageDigest.getInstance("SHA-1");
            cript.reset();
            cript.update(input.getBytes("utf8"));
            String passwordHash = new BigInteger(1, cript.digest()).toString(16);
            return passwordHash;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
