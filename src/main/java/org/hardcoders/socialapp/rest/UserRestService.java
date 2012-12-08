package org.hardcoders.socialapp.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hardcoders.socialapp.model.User;
import org.hardcoders.socialapp.rest.views.VUser;
import org.hardcoders.socialapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: AGutierrez6
 * Date: 12/7/12
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/user")
@Controller
public class UserRestService {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/logged")
    @Produces("application/json")
    public Response loggedUser(@Context HttpServletRequest request) {
        Gson gson = new Gson();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        User user = userService.findById(Long.valueOf(userId));
        return Response.ok(gson.toJson(VUser.getVUSer(user))).build();
    }

    @POST
    @Path("/login")
    @Produces("application/json")
    public Response login(@Context HttpServletRequest request, @FormParam("username") String username, @FormParam("password") String password) {
        Gson gson = new Gson();
        if (userService.loginUserWithPassword(username, password)) {
            HttpSession session = request.getSession(true);
            User user = userService.findByUserName(username);
            session.setAttribute("userId", user.getId());
            return Response.ok(gson.toJson(VUser.getVUSer(user))).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\"=\"Invalid user or password\"}").build();
        }
    }

    @POST
    @Path("/logoff")
    @Produces("application/json")
    public Response logoff(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        session.removeAttribute("userId");
        session.invalidate();
        return Response.ok().build();
    }


    @POST
    @Path("/create")
    @Produces("application/json")
    public Response createUser(@Context HttpServletRequest request, @FormParam("username") String username, @FormParam("password") String password) {
        Gson gson = new Gson();
        User user;
        try {
        user = userService.createUser(username, password);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\"=\""+ex.getMessage()+"\"}").build();
        }
        return login(request, username, password);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUser(String vUserString) {
        Gson gson = new Gson();
        VUser vUser = gson.fromJson(vUserString, VUser.class);
        User user = userService.findById(vUser.getId());
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        user.setMobile(vUser.getMobile());
        if (!StringUtils.isEmpty(vUser.getMobile())) {
            user.setSendByMobile(true);
        }
        user.setTweeter(vUser.getTweeter());
        if (!StringUtils.isEmpty(vUser.getTweeter())) {
            user.setSendByTweeter(true);
        }
        user.setEmail(vUser.getEmail());
        if (!StringUtils.isEmpty(vUser.getEmail())) {
            user.setSendByEmail(true);
        }
        userService.updateUser(user);
        return Response.ok(gson.toJson(VUser.getVUSer(user))).build();
    }

}
